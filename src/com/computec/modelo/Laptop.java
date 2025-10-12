package com.computec.modelo;

public class Laptop extends Equipo {
    private double pantallaPulgadas;
    private boolean esTouch;
    private int puertosUsb;

    public Laptop() {}

    public Laptop(String modelo, String cpu, int discoDuroMb, int ramGb, double precio, Categoria categoria,
            double pantallaPulgadas, boolean esTouch, int puertosUsb) {
        super(modelo, cpu, discoDuroMb, ramGb, precio, categoria);
        this.pantallaPulgadas = validarDoublePositivo(pantallaPulgadas, "Tamaño pantalla (pulgadas)");
        this.esTouch = esTouch;
        this.puertosUsb = validarIntPositivo(puertosUsb, "Puertos USB");
    }

    public Laptop(int idEquipo, String modelo, String cpu, int discoDuroMb,
            int ramGb, double precio, Categoria categoria,
            double pantallaPulgadas, boolean esTouch, int puertosUsb) {
        super(idEquipo, modelo, cpu, discoDuroMb, ramGb, precio, categoria);
        this.pantallaPulgadas = validarDoublePositivo(pantallaPulgadas, "Tamaño pantalla (pulgadas)");
        this.esTouch = esTouch;
        this.puertosUsb = validarIntPositivo(puertosUsb, "Puertos USB");
    }

    public double getPantallaPulgadas() {
        return pantallaPulgadas;
    }

    public void setPantallaPulgadas(double pantallaPulgadas) {
        this.pantallaPulgadas = validarDoublePositivo(pantallaPulgadas, "Tamaño pantalla (pulgadas)");
    }

    public boolean isEsTouch() {
        return esTouch;
    }

    public void setEsTouch(boolean esTouch) {
        this.esTouch = esTouch;
    }

    public int getPuertosUsb() {
        return puertosUsb;
    }

    public void setPuertosUsb(int puertosUsb) {
        this.puertosUsb = validarIntPositivo(puertosUsb, "Puertos USB");
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamaño pantalla (pulgadas): " + pantallaPulgadas + ", Touch: " + (esTouch ? "Si" : "No") + ", Puertos USB: " + puertosUsb;
    }
}
