package com.digitechfp.curso_ad;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final Poligono poligono;
    public IDibujable dibujaTitulo = new IDibujable() {
        @Override
        public void dibuja(Graphics g) {
            g.drawString("Titulo", 50, 50);
        }
    };

    public Frame(Poligono poligono) {
        this.poligono = poligono;
        setTitle("Dibuja Poligono");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        poligono.dibuja(g);
        dibujaTitulo.dibuja(g);
    }

}
