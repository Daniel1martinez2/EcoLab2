package com.example.semana2lab;

import android.util.Log;

import java.util.ArrayList;
import java.util.Scanner;

public class Pregunta {
    String ejercicio;
    int num1;
    int num2;
    int operacionTipo;
    //0 = +, 1 = -, 2= *, 3=/
    int respuesta;
    ArrayList<Pregunta> pregunticas;

    public Pregunta(int num1, int num2, int operacionTipo){
        this.num1= num1;
        this.num2= num2;
        this.operacionTipo = operacionTipo;
    }
//////

    void operar(){
        switch (operacionTipo){
            case 0:  respuesta= num1 + num2;
            ejercicio = ""+num1+"+"+num2;
            break;
            case 1:  respuesta= num1 - num2;
                ejercicio = ""+num1+"-"+num2;
                break;
            case 2:  respuesta= num1 * num2;
                ejercicio = ""+num1+"*"+num2;
                break;
            case 3:  respuesta= num1 / num2;
                ejercicio = ""+num1+"/"+num2;
                break;
        }
        //Log.e("resultado",""+respuesta);
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public Pregunta setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
        return this;
    }

    public int getNum1() {
        return num1;
    }

    public Pregunta setNum1(int num1) {
        this.num1 = num1;
        return this;
    }

    public int getNum2() {
        return num2;
    }

    public Pregunta setNum2(int num2) {
        this.num2 = num2;
        return this;
    }

    public int getOperacionTipo() {
        return operacionTipo;
    }

    public Pregunta setOperacionTipo(int operacionTipo) {
        this.operacionTipo = operacionTipo;
        return this;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public Pregunta setRespuesta(int respuesta) {
        this.respuesta = respuesta;
        return this;
    }


//////
}
