/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class GanarPanel extends JPanel{
   
    private String mensaje = "Has ganado!!!!!\nIntroduce tu nombre:\n";
    private String nom;
    public GanarPanel(){
        
        
        nom = (String) JOptionPane.showInputDialog(this,mensaje,"Has ganado", JOptionPane.INFORMATION_MESSAGE);
    }
    public String GetNombre(){
        return nom;
    }
}
