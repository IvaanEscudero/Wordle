/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JMenuBar;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class MenuBar extends JMenuBar{
    private JMenu menu;
    private JMenu ayuda;
    private JMenuItem salir;
    private JMenuItem manual;
    private JMenuItem daltonismo;
    public MenuBar(){
        menu = new JMenu("Menú");
        ayuda = new JMenu("Ayuda");
        manual = new JMenuItem("Manual");
        manual.setActionCommand("Manual");
        salir = new JMenuItem("Salir");
        salir.setActionCommand("Salir");
        daltonismo = new JMenuItem("Modo daltónico");
        daltonismo.setActionCommand("daltonismo");
        
        
        
        this.add(menu);
        this.add(ayuda);
        
        ayuda.add(manual);
        ayuda.add(daltonismo);
      
        menu.add(salir);
    }
    public void setActionListener(ActionListener actionListener){
    salir.addActionListener(actionListener);
    daltonismo.addActionListener(actionListener);
    manual.addActionListener(actionListener);
    }
}
