package com.digitechfp.curso_ad;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private IPoligono poligono;
    public IDibujable dibujaTitulo = new IDibujable() {
        @Override
        public void dibuja(Graphics g) {
            g.drawString("Titulo", 50, 50);
        }
    };
    public IDibujable dtitulo = (g) -> {
        g.drawString("Titulo", 50, 50);
    };
    public Frame(IPoligono poligono) {
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
