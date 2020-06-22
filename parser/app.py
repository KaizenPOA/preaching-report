import os
import db
from data import months
import broker
from datetime import datetime, timedelta
from flask import Flask, url_for, flash, redirect, render_template, request, jsonify
from parser import parse_report

previous_month = (datetime.now().replace(day=1) - timedelta(days=1)).month


def create_app():
    app = Flask(__name__, static_folder='static',
                instance_relative_config=True)
    app.config.from_mapping(
        SECRET_KEY='dev', DATABASE=os.path.join(app.instance_path, 'parser.sqlite'),
    )
    db.init(app)

    try:
        os.makedirs(app.instance_path)
    except OSError:
        pass

    @app.route('/report', methods=['POST'])
    def report_text():
        report = request.form['report']
        parsed = parse_report(report)

        if not parsed['nome']:
            flash('Informe o nome do publicador', 'error')
        elif parsed['horas'] <= 0:
            flash('Informe as horas do mês', 'error')
        else:
            parsed['mes'] = int(request.form['month'])
            broker.publish(parsed)
            flash('Obrigado por enviar seu relatório!')
        return redirect(url_for('home', report=report))

    @app.route('/')
    def home():
        return render_template('index.html', months=months, mes=previous_month, **request.args)

    @app.route('/login')
    def login():
        return ''

    @app.route('/logout')
    def logout():
        return ''

    # @app.route('/report-data', methods=['POST'])
    # def report_data():
    #     data = request.form.to_dict()
    #     return data

    return app
