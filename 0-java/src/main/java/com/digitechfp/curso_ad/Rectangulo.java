package com.digitechfp.curso_ad;

import java.awt.*;

public class Rectangulo extends Poligono {
    private final double base;
    private final double altura;

    public Rectangulo(double base, double altura) {
        this(0, 0, base, altura);
    }

    public Rectangulo(double x, double y, double base, double altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }


    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return 2 * (base + altura);
    }

    @Override
    public void dibuja(Graphics g) {
        g.drawRect((int)x, (int)y, (int)base, (int)altura);
    }

}
