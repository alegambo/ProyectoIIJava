/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.ArbolFractal;

/**
 *
 * @author Alejandro
 */
public class ControladorAplicacion {

    public ControladorAplicacion(ArbolFractal newData) {
        this.arbol = newData;
    }

    public ControladorAplicacion() {
        this(new ArbolFractal());
    }

    public void setAnchura(int x) {
        arbol.setAnchura(x);
    }

    public void setAltura(int x) {
        arbol.setAltura(x);
    }

    public void setAngulo(double x) {
        arbol.setAngulo(x);
    }

    public void setProfundidad(int x) {
        arbol.setProfundidad(x);
    }

    public int getAltura() {
        return arbol.getAltura();
    }

    public int getAnchura() {
        return arbol.getAnchura();
    }

    public double getAngulo() {
        return arbol.getAngulo();
    }

    public int getProfundidad() {
        return arbol.getProfundidad();
    }

    public ArbolFractal obtenerArbol() {
        return arbol;
    }

    private ArbolFractal arbol;
}
