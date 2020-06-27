import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:shared_preferences/shared_preferences.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final relatorio_enviado = true;
    var mes = new DateTime.now();
    if (!relatorio_enviado) {
       mes = new DateTime.now().subtract(new Duration(days: 1));
    }

    return MaterialApp(
      theme: ThemeData.light(),
      title: 'MyReport',
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.lightBlue,
          title: Row(
            children: [
              Image(
                image: new AssetImage('assets/kaizen.png'),
                height: 30,
              ),
              Padding(
                padding: EdgeInsets.only(left: 15),
                child: Text('Meu relatório', style: TextStyle(fontWeight: FontWeight.bold)),
              )
            ],
          )
        ),
        body: Container(
          height: double.infinity,
          child: Padding(
            padding: EdgeInsets.all(10),
            child: Column(
              children: [
                  Expanded(
                    child: ListView(
                      children: [
                        Text(
                          'Douglas Nomizo',
                          textAlign: TextAlign.center,
                          style: TextStyle(fontSize: 26.0, fontWeight: FontWeight.bold),
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Horas'),
                          keyboardType: TextInputType.number,
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Publicações'),
                          keyboardType: TextInputType.number,
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Vídeos'),
                          keyboardType: TextInputType.number,
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Revisitas'),
                          keyboardType: TextInputType.number,
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Estudos'),
                          keyboardType: TextInputType.number,
                        ),
                        TextFormField(
                          decoration: InputDecoration(labelText: 'Observações'),
                          maxLines: 3,
                        ),
                      ],
                    ),
                  ),
                  ButtonTheme(
                    textTheme: ButtonTextTheme.primary,
                    minWidth: double.infinity,
                    child: RaisedButton(
                      onPressed: () {},
                      child: Text("ENVIAR RELATÓRIO", style: TextStyle(fontWeight: FontWeight.bold)),
                    ),
                  ),
                ]
              )
          )
        )
      ),
    );
  }
}


class CurrentReport extends StatefulWidget {
  @override
  _CurrentReportState createState() => _CurrentReportState();
}

class _CurrentReportState extends State<CurrentReport> {
  @override
  void initState() {
    super.initState();

  }


  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
