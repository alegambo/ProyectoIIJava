/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra32;

import control.ControladorAplicacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;
import javafx.beans.value.ObservableValue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.*;

/**
 *
 * @author Alejandro
 */
public class Ventana extends JFrame {

    public Ventana(String titulo, ControladorAplicacion nuevogestor) {
        super(titulo);

        this.gestor = nuevogestor;

        //ajustarComponentes(getContentPane());
        setup();
    }

    public void ajustarComponentes(Container c) {
        event ev = new event();
        controlaAngulo = new JSlider(JSlider.VERTICAL, 0, 314, 0);
        controlaAngulo.setPreferredSize(new Dimension(45, 720));
        controlaAngulo.setPaintTicks(true);
        controlaAngulo.setMajorTickSpacing(180);
        controlaAngulo.setMinorTickSpacing(-180);
        controlaAngulo.setMaximum(180);
        controlaAngulo.setMinimum(-180);
        controlaAngulo.addChangeListener(ev);
        controlaRamificacion = new JSlider(JSlider.VERTICAL, 0, 15, 0);
        controlaRamificacion.setPreferredSize(new Dimension(50, 720));
        controlaRamificacion.setPaintTicks(true);
        controlaRamificacion.setMinorTickSpacing(2);
        controlaRamificacion.setMaximum(180);
        controlaRamificacion.setMinimum(-180);
        controlaRamificacion.addChangeListener(ev);
        controlaTamano = new JSlider(JSlider.VERTICAL, 0, 100, 40);
        controlaTamano.setPreferredSize(new Dimension(55, 640));
        controlaTamano.setPaintTicks(true);
        controlaTamano.setMinorTickSpacing(10);
        controlaTamano.setMaximum(180);
        controlaTamano.setMinimum(-180);
        controlaTamano.addChangeListener(ev);
        sliders = new JPanel();
        meterEnPanel(sliders);
        setLayout(new BorderLayout());
        c.add(BorderLayout.EAST, sliders);
        sliders.setBackground(Color.DARK_GRAY);

        arbol = new JPanel() {
            public JPanel init() {
                setBackground(Color.WHITE);
                return this;
            }

            private void inicializar() {
                gestor.setAnchura(getWidth() / 2);
                gestor.setAltura(getHeight());
                gestor.setAngulo(-90);
                gestor.setProfundidad(8); //aqui cambia el valor
            }

            @Override
            public void paintComponent(Graphics eg) {
                super.paintComponent(eg);
                Graphics2D g = (Graphics2D) eg;
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(Color.BLACK);
                if (e) {
                    if (!init) {
                        inicializar();
                        init = true;
                    }
                    anchura = gestor.getAnchura();
                    altura = gestor.getAltura();
                    profundidad = gestor.getProfundidad();
                    angulo = gestor.getAngulo();
                    gestor.obtenerArbol().dibujarArbol2(g);
                }
            }
        };

        arbol.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.add(BorderLayout.CENTER, arbol);

    }

    public void inicialstate() {
        /*event e = new event();
        controlaTamano = new JSlider(JSlider.VERTICAL, 0, 100, 40);
        controlaTamano.setPreferredSize(new Dimension(55, 640));
        controlaTamano.setPaintTicks(true);
        controlaTamano.setMinorTickSpacing(10);
        controlaTamano.addChangeListener(e);*/

        controlaRamificacion = new JSlider(JSlider.VERTICAL, 0, 15, 0);
        controlaRamificacion.setPreferredSize(new Dimension(50, 720));
        controlaRamificacion.setPaintTicks(true);
        controlaRamificacion.setMinorTickSpacing(2);
        controlaAngulo = new JSlider(JSlider.VERTICAL, 0, 314, 0);
        controlaAngulo.setPreferredSize(new Dimension(45, 720));
        controlaAngulo.setPaintTicks(true);
        controlaAngulo.setMajorTickSpacing(180);
        controlaAngulo.setMinorTickSpacing(-180);
        controlaAngulo.setMaximum(180);
        controlaAngulo.setMinimum(-180);
    }

    class event implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            value3= controlaTamano.getValue();
            cambiarTamano();
            System.err.println("El tamaño cambió, ahora es " + value2);
            value2=controlaRamificacion.getValue();
            cambiarRamificacion();
            System.err.println("ramificaciones cambiadas en " + value2);
            value = controlaAngulo.getValue();
            cambiarAngulo();
            System.err.println("Valor del angulo " + value);
        }
    }

    public void setup() {
        setSize(1000, 650);
        setLocationByPlatform(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void meterEnPanel(JPanel c) {

        c.add(controlaTamano);
        c.add(controlaRamificacion);
        c.add(controlaAngulo);

    }

    public void changed(ObservableValue ov, Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void cambiarTamano(){
    gestor.setAltura(controlaTamano.getValue());
    }
    
    public void cambiarRamificacion(){
    gestor.setProfundidad(controlaRamificacion.getValue());
    }
    public void cambiarAngulo() {
        gestor.setAltura(controlaAngulo.getValue());
    }

    public void init() {
        ajustarComponentes(getContentPane());
        setVisible(true);
    }

    private int anchura;
    private int profundidad;
    private double angulo;
    private int altura;
    private JPanel arbol;
    private final ControladorAplicacion gestor;
    private JPanel sliders;
    private JSlider controlaTamano;
    private JSlider controlaRamificacion;
    private JSlider controlaAngulo;
    private boolean e = true;
    private boolean init;
    private int value;
    private int value2;
    private int value3;

}
