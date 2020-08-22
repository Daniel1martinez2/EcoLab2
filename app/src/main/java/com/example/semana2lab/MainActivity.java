package com.example.semana2lab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private int conter;
    private EditText respuesta;
    private TextView pregunta;
    //private Pregunta preguntame;
    private Button boton;
    private int escribio;
    private ArrayList<Pregunta> pregunticas;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////
        conter = 0;
        pregunticas = new ArrayList<Pregunta>();
        //-------------banco
        pregunticas.add(new Pregunta(1,2,2));
        pregunticas.add(new Pregunta(5,3,2));
        pregunticas.add(new Pregunta(4,3,2));
        pregunticas.add(new Pregunta(6,3,2));

        //-------------final
        pregunta = findViewById(R.id.pregunta);
        respuesta = findViewById(R.id.respuesta);
        boton = findViewById(R.id.boton);
        for(int i = 0; i <pregunticas.size(); i++){
            pregunticas.get(i).operar();
        }
        if(pregunticas.get(conter)!=null&&pregunticas.get(conter+1)!=null){
            pregunta.setText(pregunticas.get(conter).getEjercicio());
           // Log.e("alo","suuuuuuu"+pregunticas.get(1).getEjercicio());
        }
        boton.setOnClickListener(this);
    }
    public void onClick(View view) {
        if(respuesta.getText().toString() != ""){
            int preguntaRes = pregunticas.get(conter).getRespuesta();
            int preguntaTry = Integer.parseInt(respuesta.getText().toString());
            if(preguntaRes == preguntaTry ){
                Log.e("alo","sgraduateeeeeeeeeeeeeeeeee");
                conter=(int)Math.floor(Math.random()*pregunticas.size());
                Log.e("test", ""+(int)Math.floor(Math.random()*7)+" esperalo "+pregunticas.get(conter).getRespuesta()+" aaaaaa"+respuesta.getText());
                pregunta.setText(""+pregunticas.get(conter).getEjercicio());
                respuesta.setTextColor(Color.parseColor("#008000"));
                respuesta.setText("");

            }else{

                respuesta.setTextColor(Color.parseColor("#FF0000"));
            }

        }


    }
}