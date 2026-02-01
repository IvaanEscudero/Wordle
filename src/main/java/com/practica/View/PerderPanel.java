/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class PerderPanel extends JPanel{
    
    private String mensaje = "\tHas perdido!!!!!\n\tIntentalo de nuevo.\n";
    public PerderPanel(){
        
        JOptionPane.showConfirmDialog(this,mensaje,"Perdido", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
    }    
}
