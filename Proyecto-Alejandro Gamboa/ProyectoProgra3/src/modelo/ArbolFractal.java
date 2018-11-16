/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public class ArbolFractal implements Observable {

    public ArbolFractal(Graphics g, int altura, int anchura, int profundidad, double angulo) {
        this.g = g;
        this.altura = altura;
        this.anchura = anchura;
        this.profundidad = profundidad;
        this.angulo = angulo;
    }
    public  ArbolFractal(){

} 
    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    public void dibujarArbol(Graphics g, int x1 ,int y1 , double angulo,int profundidad){
         if (profundidad == 0)
            return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angulo)) * profundidad * 15.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angulo)) * profundidad * 15.0);
        g.drawLine(x1, y1, x2, y2);
        dibujarArbol(g, x2, y2, angulo - 20, profundidad - 1);
        dibujarArbol(g, x2, y2, angulo + 20, profundidad - 1);
        
    }
    public void dibujarArbol2(Graphics g){
        dibujarArbol(g,anchura,altura,angulo,profundidad);
    }
    Graphics g;
    int altura;
    int anchura;
    int profundidad;
    double angulo;

    @Override
    public void addListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
