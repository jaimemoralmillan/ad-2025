package com.digitechfp.curso_ad;

import java.awt.*;

abstract public class Poligono implements IPoligono, IDibujable{
    protected double x;
    protected double y;

    Poligono(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Poligono() {
        this(0, 0);
    }
    //region Abstract Methods
    abstract public double area();
    abstract public double perimetro();
    //endregion
    public void mover(double x, double y) {
        this.x += x;
        this.y += y;
    }
    abstract public void dibuja (Graphics g);

}
