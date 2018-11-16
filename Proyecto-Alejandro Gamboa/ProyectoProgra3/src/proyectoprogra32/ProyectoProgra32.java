/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra32;

import control.ControladorAplicacion;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alejandro
 */
public class ProyectoProgra32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(()->{mostrar();});
    }
    public static void mostrar(){

    new Ventana("proyecto",new ControladorAplicacion()).init();
}
}
