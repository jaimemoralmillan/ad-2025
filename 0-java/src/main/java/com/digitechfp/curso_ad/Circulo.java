package com.digitechfp.curso_ad;

import java.awt.*;

public class Circulo extends Poligono {
    private final double radio;

    public Circulo(double x, double y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public Circulo(double radio) {
        this(0, 0, radio);
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public void dibuja (Graphics g) {
        g.drawOval((int)x, (int)y, (int)radio, (int)radio);
    }
}
