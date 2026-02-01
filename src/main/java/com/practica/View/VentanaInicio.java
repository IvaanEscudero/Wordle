/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class VentanaInicio extends JPanel {
    private JButton juego;
    private JButton ranking;
    private JTextPane descripcion;
    private String mensaje = "El objetivo del juego es simple, adivinar la palabra oculta. "+
            "El jugador 1 registra una palabra de 3 a 5 letras\n y el jugador 2 tiene 8 intentos para adivinarla." +
            "En cada ronda el juego pinta cada letra de un color indicando\nsi esa letra "+
            "se encuentra o no en la palabra y si se encuentra en la posición correcta."+
            "\n\nVERDE significa que la letra está en la palabra y en la posición CORRECTA.\n"+
            "AMARILLO significa que la letra letra está presente en la palabra pero en "+
            "la posición INCORRECTA.\nGRIS significa que la letra letra NO está "+
            "presente en la palabra.\n\nSi el jugador 2 consigue adivinarla saldrá "+
            "un mensaje para introducir su nombre para luego poder verlo\nen la lista de ranking si es uno de los 10 mejores.\n\n"+
            "\t\t\t EJEMPLO\nImagina que la palabra oculta sea RUBIA. Empezamos con una palabra como FAROL.\n\t\t\t F A R O L "+
            "\nEl amarillo indica que tanto la letra R como la A estan en la palabra pero en la posicion incorrecta."+
            " Puedo ahora intentar con una palabra que tenga la R y la A pero en otras posiciones como ROSAS.\n\t\t\t"+
            "R O S A S \nEl color verde indica que la letra R está en la posición correcta mientras que la A sigue estando en la incorrecta.\n"+
            "Al final todas las letras deberían ser verdes.\n\t\t\tR U B I A \n\n\nPara empezar seleccione el botón 'Nueva Partida'.\n"+
            "En cambio, para ver el ránking seleccione 'Ránking'.";
    private Highlighter.HighlightPainter greenPainter;
    private Highlighter.HighlightPainter yellowPainter;
    private Highlighter.HighlightPainter grayPainter;
    public VentanaInicio() throws BadLocationException{
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        juego = new JButton("Nueva Partida");
        juego.setActionCommand("NuevaPartida");
        ranking = new JButton("Ránking");
        ranking.setActionCommand("ranking");
        
        descripcion = new JTextPane();
        descripcion.setText(mensaje);
        descripcion.setEditable(false);
        
        greenPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
        yellowPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
        grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.gray);
        //Marcar las lineas de explicacion VERDE, AMARILLO y GRIS
        descripcion.getHighlighter().addHighlight(311, 385, greenPainter);
        descripcion.getHighlighter().addHighlight(386, 483, yellowPainter);
        descripcion.getHighlighter().addHighlight(484, 549, grayPainter);
        //Marcar la palabra FAROL
        descripcion.getHighlighter().addHighlight(802, 804, grayPainter);    
        descripcion.getHighlighter().addHighlight(804, 808, yellowPainter);
        descripcion.getHighlighter().addHighlight(808, 812, grayPainter); 
        //Marcar la palabra ROSAS
        descripcion.getHighlighter().addHighlight(1014, 1016, greenPainter);
        descripcion.getHighlighter().addHighlight(1016, 1020, grayPainter);
        descripcion.getHighlighter().addHighlight(1020, 1022, yellowPainter);
        descripcion.getHighlighter().addHighlight(1022, 1024, grayPainter);
        //Marcar la palabra RUBIA
        descripcion.getHighlighter().addHighlight(1191, 1202, greenPainter);
        
        this.add(descripcion);
        this.add(juego);
        this.add(ranking);
        this.setSize(600,600);
        this.setVisible(true);
    }

        public void setActionListener(ActionListener al){
        juego.addActionListener(al);
        ranking.addActionListener(al);

    }
        
}
