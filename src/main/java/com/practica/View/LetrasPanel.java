/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class LetrasPanel extends JPanel{
    private JPanel mmm = new JPanel();
    private final int INTENTOS = 8;
    private final Color[][] col_fondo = {{Color.GRAY,Color.YELLOW,Color.GREEN},
                                        {new Color(226,33,38),new Color(247,126,35),new Color(18,104,55)}};
    private JTextField[][] matriz = new JTextField [8][5];
    private String palabra = "";
    private String c = "";
    private int[] cod;
    private int fila = 0;
    private int daltonismo = 0;
    


    public LetrasPanel(){
       
        this.setLayout(new BorderLayout());
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.SOUTH);
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.NORTH);
        mmm.setLayout(new GridLayout(INTENTOS,palabra.length()));
        this.add(mmm,BorderLayout.CENTER);
        for(int i = 0;i < INTENTOS;i++)
        {
            for(int j = 0; j < 5;j++)
            {
                matriz[i][j] = new JTextField("",1);
                matriz[i][j].setColumns(1);
                mmm.add(matriz[i][j]);
                matriz[i][j].addKeyListener(new KeyAdapter()
            {
            int cont = 1;
            public void keyTyped(KeyEvent e)
            {
                char caracter = e.getKeyChar();
                if(caracter == '\n')
                    cont = 1;
                // caracter no valido
                if(((caracter < 'A') || (caracter > 'Z')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) || (cont > 1))
                {
                    e.consume();  // ignorar el evento de teclado
                }
                else if(caracter != '\b')
                {
                    cont++;  
                }
                if(caracter == '\b' && cont > 1 )
                    cont--;
               
            }
        });
                matriz[i][j].setActionCommand("Intento");
               
            }
        }
        
       
    }
    public void setPalabra(String palabra){
        this.palabra = palabra;
        
    }
    public void DimensionarTablero(){
        for(int i = 0; i < INTENTOS;i++)
        {
            for(int j = 0; j < 5;j++)
            {
                if((j > palabra.length()-1) || (i > 0)){
                    matriz[i][j].setVisible(false);
                    matriz[i][j].setEditable(false);
                   
                }
                    
            }
        }
    }
    public void JuntarPalabra(){
        c = "";
        for(int i = 0; i < palabra.length();i++)
        {
            c = c + matriz[fila][i].getText();
        }
    }
        
    public String getIntentoPalabra(){
        return c;
    }
    
    public void setActionListener(ActionListener al){
        
        for(int i = 0;i<INTENTOS;i++)
        {
            for(int j = 0; j < 5;j++)
            {
                matriz[i][j].addActionListener(al);
            }
        }
    }
    public void setCodigo(int[] cod){
        this.cod = cod;
    }
    public void ColorearFondo(){
        for(int i = 0;i < palabra.length();i++)
        {
            matriz[fila][i].setBackground(col_fondo[daltonismo][cod[i]]);
            matriz[fila][i].setEditable(false);
        }
        fila++;
        if(fila < INTENTOS){
            
            for(int i = 0;i < palabra.length();i++)
            {
                matriz[fila][i].setVisible(true);
                matriz[fila][i].setEditable(true);
                matriz[fila][i].setEnabled(true);
            }
            
        }
        
    }
    public int GetNumIntento(){
        return fila;
    }
    
    public void ResetGame(){
    for(int i = 0; i < INTENTOS;i++)
        {
            for(int j = 0; j < 5;j++)
            {
               matriz[i][j].setText("");
               matriz[i][j].setColumns(1);
               
               matriz[i][j].setEditable(true);
               
               matriz[i][j].setVisible(true);
               matriz[i][j].setBackground(Color.WHITE);
               
               
            }
        }
        
        fila = 0;
        c = "";
        palabra = "";
    }
    public void daltonismo_si(){
        daltonismo = 1;
    }
}
