package com.digitechfp.curso_ad;

public interface IPoligono extends IDibujable
{
    double area();
    double perimetro();
    void mover (double x, double y);
}
