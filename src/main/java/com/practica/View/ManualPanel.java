/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class ManualPanel extends JPanel{
    private String mensaje = "El objetivo del juego es simple, adivinar la palabra oculta. "+
            "El jugador 1 registra una palabra de 3 a 5 letras y el jugador 2 tiene 8 intentos para adivinarla.\n" +
            "En cada ronda el juego pinta cada letra de un color indicando si esa letra "+
            "se encuentra o no en la palabra y si se encuentra en la posición correcta."+
            "\n\nVERDE significa que la letra está en la palabra y en la posición CORRECTA.\n"+
            "AMARILLO significa que la letra letra está presente en la palabra pero en "+
            "la posición INCORRECTA.\nGRIS significa que la letra letra NO está "+
            "presente en la palabra.\n\nSi el jugador 2 consigue adivinarla saldrá "+
            "un mensaje para introducir su nombre para luego poder verlo en la lista de ranking si es uno de los 10 mejores.";
    private JPanel contents = new JPanel(new BorderLayout());
    private JTextPane text = new JTextPane();
    private Highlighter.HighlightPainter greenPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
    private Highlighter.HighlightPainter yellowPainter =  new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
    private Highlighter.HighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.gray);
    public ManualPanel() throws BadLocationException {
        text.setText(mensaje);
        
        try{
            text.getHighlighter().addHighlight(311, 385, greenPainter);
            text.getHighlighter().addHighlight(386, 483, yellowPainter);
            text.getHighlighter().addHighlight(484, 549, grayPainter);
            
        
        }catch(BadLocationException ble){}
        
        text.setEditable(false);
        
        contents.add(text,BorderLayout.CENTER);
        
        
        
        
        
        JOptionPane.showConfirmDialog(this,contents,"Manual", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        
    }
}
