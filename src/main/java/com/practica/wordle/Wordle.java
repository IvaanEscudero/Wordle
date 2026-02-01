/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.practica.wordle;
import com.practica.Controller.controller;
import com.practica.Model.model;
import com.practica.View.view;
import javax.swing.text.BadLocationException;


/**
 *
 * @author Iván Escudero y Pau Linares
 */
public class Wordle {

    public static void main(String[] args) throws BadLocationException {
        model m = new model();
        view v = new view(m);
        controller c = new controller(m,v);
    }
}
