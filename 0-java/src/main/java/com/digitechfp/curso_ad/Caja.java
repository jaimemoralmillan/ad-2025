package com.digitechfp.curso_ad;

/**
 * The type Caja.
 *
 * @param <T> the type parameter
 */
public class Caja<T> {
    private T contenido;

    /**
     * Instantiates a new Caja.
     *
     * @param contenido the contenido
     */
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Gets contenido.
     *
     * @return the contenido
     */
    public T getContenido() {
        return contenido;
    }

    /**
     * Sets contenido.
     *
     * @param contenido the contenido
     */
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "contenido=" + contenido +
                '}';
    }
}