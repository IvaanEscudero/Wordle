/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.Controller;
import com.practica.Model.model;
import com.practica.View.GanarPanel;
import com.practica.View.LetrasPanel;
import com.practica.View.ManualPanel;
import com.practica.View.PerderPanel;
import com.practica.View.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class controller {
    private model m;
    private view v;
    private String palabra = "";
    private String nom = "";
    private ArrayList nom_v = new ArrayList();
    private GanarPanel gp;
    private PerderPanel pp;
    public controller(model m, view v){
        this.m = m;
        this.v = v;
        
        v.setActionListener(new MenuControllerActionListener());
        
    }

    public class MenuControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command=ae.getActionCommand();
            switch(command){
                case "Salir":
                    System.out.println("MenuController : Menu 'Salir'.");
                    System.exit(0);
                    break;
                case "Manual":
                    System.out.println("MenuController : Menu 'Manual'.");
                {
                    try {
                        ManualPanel m = new ManualPanel();
                    } catch (BadLocationException ex) {
                        Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "daltonismo":
                    System.out.println("MenuController : Menu 'daltonismo'.");
                {
                    try {
                        v.Daltonismo();
                       
                    } catch (BadLocationException ex) {
                        Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                
                
                case "NuevaPartida":
                    System.out.println("MenuController : Menu 'NuevaPartida'.");
                    v.VentanaInicioCerrarVentana();
                    v.ElegirPalabraAbrirVentana();
                    
                    break;
                case "ranking":
                    System.out.println("MenuController : Menu 'ranking'.");
                    v.VentanaInicioCerrarVentana();
                    v.RankingPanelAbrirVentana();
                    break;
                case "AtrasRanking":
                    System.out.println("MenuController : Menu 'ranking'.");
                    v.RankingPanelCerrarVentana();
                    v.VentanaInicioAbrirVentana();
                    break;
                case "AceptarPalabra":
                    System.out.println("MenuController : Menu 'AceptarPalabra'.");
                    palabra = v.GetPalabra();
                    v.ElegirPalabraCerrarVentana();
                    m.setPalabra(palabra);
                    v.SetPalabraLetrasPanel(palabra);
                    v.LetrasPanelAbrirVentana();
                   
                    break;
                case "AtrasPalabra":
                    System.out.println("MenuController : Menu 'AtrasPalabra'.");
                    v.ElegirPalabraCerrarVentana();
                    v.VentanaInicioAbrirVentana();
                    break;
                case "Intento":
                    System.out.println("MenuController : 'Intento'.");
                    v.JuntarPalabra();
                    //Si se ha introducido un intento valido
                     
                    if(palabra.length()==v.getIntentoPalabra().length())
                    {
                       m.setPalabraIntento(v.getIntentoPalabra());
                        v.setCodigo(m.Calculo());
                        v.ColorearFondo();
                        if(palabra.equals(v.getIntentoPalabra()) ){
                            gp = new GanarPanel();
                            nom_v.add(v.GetNumIntento()+gp.GetNombre());
                            nom_v = m.OrdenarRanking(nom_v);
                            v.AnyadirRanking(nom_v);
                            v.LetrasPanelCerrarVentana();
                            v.VentanaInicioAbrirVentana();
                            
                        } 
                        else if (v.GetNumIntento() == 8){
                            pp = new PerderPanel();
                            v.LetrasPanelCerrarVentana();
                            v.VentanaInicioAbrirVentana();
                        }
                            
                    }
                   
                    break;
                }
            
                
        }
    }
    }
