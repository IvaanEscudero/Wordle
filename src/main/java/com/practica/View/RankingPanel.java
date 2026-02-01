/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class RankingPanel extends JPanel {
    private JTextArea r = new JTextArea();
    private JButton b;
    private String m = "Este es el ranking de los 10 jugadores que en menos intentos han adivinado la palabra: \n\n";
    public RankingPanel(){
        this.setLayout(new FlowLayout());
        
        //ya estan ordenados 
        this.add(r);
        r.setEditable(false);
        r.insert(m, 0);
        
        
        b = new JButton("Atrás");
        this.add(b);
        b.setActionCommand("AtrasRanking");
    }
    public void setActionListener(ActionListener al){
        b.addActionListener(al);

    }
    public void AnyadirRanking(ArrayList nom_v){
        r.setText(m);
        String aux = "";
        String ranking = "";
        int a = 0;
        if(nom_v.size() < 10)
        {
            a = nom_v.size();
        }
        else
            a = 10;
        for(int i = 0;i < a;i++)
            {
                aux = (String) nom_v.get(i);
                ranking = ranking + String.valueOf(i+1) + ". " + aux.substring(1) + " con "+ aux.charAt(0) + " intentos.\n";
            }
            r.insert(ranking, m.length());
            ranking = "";
        
        
    }
}