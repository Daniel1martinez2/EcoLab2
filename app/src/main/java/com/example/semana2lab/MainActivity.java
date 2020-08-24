package com.example.semana2lab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    private int timer = 10;
    private TextView timerView;
    private ArrayList<Pregunta> pregunticas;

    private int num1r;
    private int num2r;
    private int operator;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////
        conter = 0;
        pregunticas = new ArrayList<Pregunta>();
        //-------------banco
       /* pregunticas.add(new Pregunta(1,2,2));
        pregunticas.add(new Pregunta(5,3,2));
        pregunticas.add(new Pregunta(4,3,2));
        pregunticas.add(new Pregunta(6,3,2));*/
        for(int i = 0; i<30; i++){
            num1r = (int)Math.floor(Math.random()*11);
            num2r= (int)Math.floor(Math.random()*11);
            operator= (int)Math.floor(Math.random()*3);
            if(num1r>num2r || num1r==num2r){
                pregunticas.add(new Pregunta(num1r, num2r, operator));
                Log.e("preguntas randommmm", ""+pregunticas.size());
            }else{
                num2r= num1r+1;
            }
        }
        //-------------final
        pregunta = findViewById(R.id.pregunta);
        respuesta = findViewById(R.id.respuesta);
        boton = findViewById(R.id.boton);
        timerView = findViewById(R.id.timer);
        for(int i = 0; i <pregunticas.size(); i++){
            pregunticas.get(i).operar();
        }
        if(pregunticas.get(conter)!=null&&pregunticas.get(conter+1)!=null){
            pregunta.setText(pregunticas.get(conter).getEjercicio());
           // Log.e("alo","suuuuuuu"+pregunticas.get(1).getEjercicio());
        }
        boton.setOnClickListener(this);
        Log.e("timeeeeerrrrrrr","aaaaaaaaaaaaaaa"+timer);

        new Thread(
                ()->{

            while (timer>=0){

                try {
                    Thread.sleep(2000);
                    timer--;
                    Log.e("timeeeeerrrrrrr","aaaaaaaaaaaaaaa"+timer);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



                }
        ).start();

    }
    public void onClick(View view) {
        if(respuesta.getText().toString().matches("")==false){
            int preguntaRes = pregunticas.get(conter).getRespuesta();
            int preguntaTry = Integer.parseInt(respuesta.getText().toString());
            if(preguntaRes == preguntaTry ){
                Log.e("alo","sgraduateeeeeeeeeeeeeeeeee");
                conter=(int)Math.floor(Math.random()*pregunticas.size());
                Log.e("test", ""+(int)Math.floor(Math.random()*7)+" esperalo "+pregunticas.get(conter).getRespuesta()+" aaaaaa"+respuesta.getText());
                pregunta.setText(""+pregunticas.get(conter).getEjercicio());
                respuesta.setTextColor(Color.parseColor("#008000"));
                respuesta.setText("");
                timer = 10 ;
            }else{
                respuesta.setTextColor(Color.parseColor("#FF0000"));
            }
        }
    }



}