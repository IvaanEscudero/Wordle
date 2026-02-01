/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.View;
import com.practica.Model.model;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.text.BadLocationException;
/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class view extends JFrame {
    private VentanaInicio vi;
    private LetrasPanel lp;
    private MenuBar me = new MenuBar();
    private RankingPanel rp = new RankingPanel();
    private ElegirPalabra ep = new ElegirPalabra();
 
    public view(model m) throws BadLocationException{
        super("Wordle");
        this.vi = new VentanaInicio();
        this.setLayout(new BorderLayout());
        
        lp = new LetrasPanel();
        this.add(vi,BorderLayout.CENTER);
        this.add(lp,BorderLayout.NORTH);
        this.add(rp,BorderLayout.WEST);
        this.add(ep,BorderLayout.CENTER);
        this.setVisible(true);
        vi.setVisible(true);
        lp.setVisible(false);
        rp.setVisible(false);
        ep.setVisible(false);
        this.setSize(600,700);
        this.setJMenuBar(me);
    }
    public void setActionListener(ActionListener al){
        me.setActionListener(al);
        vi.setActionListener(al);
        rp.setActionListener(al);
        ep.setActionListener(al);
        lp.setActionListener(al);
    }
    public void VentanaInicioCerrarVentana(){
        vi.setVisible(false);
        
    }
    public void VentanaInicioAbrirVentana(){
        vi.setVisible(true);
    }
    public void LetrasPanelCerrarVentana(){
        lp.setVisible(false);
        lp.ResetGame();
    }
    public void LetrasPanelAbrirVentana(){
        lp.setVisible(true);
        lp.DimensionarTablero();
    }
    public void RankingPanelCerrarVentana(){
        rp.setVisible(false);
    }
    public void RankingPanelAbrirVentana(){
        rp.setVisible(true);
    }
    public void ElegirPalabraAbrirVentana(){
        ep.setVisible(true);
    }
    public void ElegirPalabraCerrarVentana(){
        ep.setVisible(false);
    }
    public String GetPalabra(){
        return ep.GetPalabra();
    }
    public void SetPalabraLetrasPanel(String palabra){
        lp.setPalabra(palabra);
    }
    public String getIntentoPalabra(){
        return lp.getIntentoPalabra();
    }
    public void setCodigo(int[] cod){
        lp.setCodigo(cod);
    }
    public void JuntarPalabra(){
        lp.JuntarPalabra();
    }
    public void ColorearFondo(){
         lp.ColorearFondo();
    }
    public int GetNumIntento(){
        return lp.GetNumIntento();
    }
    public void AnyadirRanking(ArrayList nom_v){
        rp.AnyadirRanking(nom_v);
    }
    public void Daltonismo() throws BadLocationException{
        lp.daltonismo_si();
        
    }
}
