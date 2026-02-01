/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Model;


import java.util.*;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class model {
    private String palabra = "";
    private String intento = "";
    private int codigo[];//   0:Gris , 1:Amarillo, 2:Verde
    private int indice;
    private boolean[] adivinadas;
    public model(){
        
        
    }
    public void setPalabra(String palabra){
        this.palabra = palabra;
    }
    public void setPalabraIntento(String intento){
        this.intento = intento;
    }
    public int[] Calculo(){
        codigo = new int[palabra.length()];
        adivinadas =new boolean[palabra.length()];
        for(int i = 0; i < palabra.length();i++)
        {
            if(intento.charAt(i)==palabra.charAt(i))
            {
                codigo[i] = 2;
                adivinadas[i] = true;
            }
            else if (palabra.contains(Character.toString(intento.charAt(i))) && (!adivinadas[palabra.indexOf(intento.charAt(i))] )){
                codigo[i] = 1;
            }
            else
                codigo[i] = 0;
        
        }
        
            
        return codigo;
    }
    public ArrayList OrdenarRanking(ArrayList nom_v){
        Collections.sort(nom_v);
        
        return nom_v;
    }
}
