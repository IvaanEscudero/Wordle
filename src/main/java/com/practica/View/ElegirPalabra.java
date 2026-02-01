/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class ElegirPalabra extends JPanel {
    private JComboBox tam = new JComboBox();
    private JTextField text = new JTextField("");
    private JButton aceptar = new JButton("Aceptar");
    private JButton atras = new JButton("Atrás");
    private JTextPane descripcion;
    private JPanel centro = new JPanel();
    private JPanel sur = new JPanel();
    private String mensaje = "Ahora el jugador 1 deberá seleccionar el tamaño de la palabra con la lista.\n\n"+
        "Luego introducirá una palabra con el tamaño elegido.\n\nUna vez escogida, necesitará darle al " +
        "botón 'Aceptar' donde el jugador 2 contará con 8 intentos para adivinarla.\n\nSi necesita volver"+
        "al menú principal seleccione 'Atrás'.\n\nNota: Debes escribir la palabra en mayúscula y sin tildes.";
    private int tam_palabra = 3;
    private int cont = 1;
    public ElegirPalabra(){
        this.setLayout(new BorderLayout());
      
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(200,200)),BorderLayout.EAST);
        
        this.add(centro,BorderLayout.CENTER);
        centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
        descripcion = new JTextPane();
        descripcion.setText(mensaje);
        descripcion.setEditable(false);
        tam.addItem("3");
        tam.addItem("4");
        tam.addItem("5");
        tam.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    tam_palabra = Integer.valueOf(event.getItem().toString());
                }
            }
        });
       
        text.setEditable(true);
        aceptar.setEnabled(false);
        text.addKeyListener(new KeyAdapter()
        {
           
            public void keyTyped(KeyEvent e)
            {
                char caracter = e.getKeyChar();
                
                // caracter no valido
                if(((caracter < 'A') || (caracter > 'Z')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) || (cont > tam_palabra))
                {
                    e.consume();  // ignorar el evento de teclado
                }
                else if(caracter != '\b')
                {
                    cont++;  
                }
                if(caracter == '\b' && cont > 1)
                    cont--;
                if(text.getText().length() >= tam_palabra-1)
                    aceptar.setEnabled(true);
                else
                    aceptar.setEnabled(false);
            }
        });
        centro.add(descripcion);
        centro.add(tam);
        centro.add(text);
        centro.setPreferredSize(new Dimension(50, 50));
        
        this.add(sur,BorderLayout.SOUTH);
        sur.setLayout(new FlowLayout());
        aceptar.setActionCommand("AceptarPalabra");
        atras.setActionCommand("AtrasPalabra");
        sur.add(aceptar);
        sur.add(atras);
        
        
        
    
} 
    public void setActionListener(ActionListener al){

        aceptar.addActionListener(al);
        atras.addActionListener(al);

    }
    public String GetPalabra(){
        return text.getText();
    }
}
