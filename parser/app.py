import os
import db
from datetime import datetime, timedelta
from flask import Flask, url_for, render_template, request, jsonify
from parser import parse_report


def create_app():
    app = Flask(__name__, static_folder="static",
                instance_relative_config=True)
    app.config.from_mapping(
        SECRET_KEY="dev", DATABASE=os.path.join(app.instance_path, "parser.sqlite"),
    )
    db.init_app(app)

    try:
        os.makedirs(app.instance_path)
    except OSError:
        pass

    @app.route("/report-text", methods=["POST"])
    def report_text():
        relatorio = request.form["relatorio"]
        parsed = parse_report(relatorio)
        return parsed

    @app.route("/report-data", methods=["POST"])
    def report_data():
        data = request.form.to_dict()
        return data

    @app.route("/")
    def root():
        meses = [
            "Janeiro",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio",
            "Junho",
            "Julho",
            "Agosto",
            "Setembro",
            "Outubro",
            "Novembro",
            "Dezembro",
        ]
        ultimo_mes = datetime.now().replace(day=1) - timedelta(days=1)
        return render_template(
            "index.html", meses=meses, mes_relatorio=ultimo_mes.month
        )

    @app.route("/login")
    def login():
        return ""

    @app.route("/logout")
    def logout():
        return ""

    return app
