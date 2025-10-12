package com.computec.modelo;

public class Desktop extends Equipo {
    private int potenciaFuente;
    private String factorForma;

    public Desktop() {}

    public Desktop(String modelo, String cpu, int discoDuroMb, int ramGb, double precio, Categoria categoria,
            int potenciaFuente, String factorForma) {
        super(modelo, cpu, discoDuroMb, ramGb, precio, categoria);
        this.potenciaFuente = validarIntPositivo(potenciaFuente, "Potencia fuente");
        this.factorForma = validarStringObligatorio(factorForma, "Factor forma");
    }

    public Desktop(int idEquipo, String modelo, String cpu, int discoDuroMb, 
            int ramGb, double precio, Categoria categoria,
            int potenciaFuente, String factorForma) {
        super(idEquipo, modelo, cpu, discoDuroMb, ramGb, precio, categoria);
        this.potenciaFuente = validarIntPositivo(potenciaFuente, "Potencia fuente");
        this.factorForma = validarStringObligatorio(factorForma, "Factor forma");
    }

    public int getPotenciaFuente() {
        return potenciaFuente;
    }

    public void setPotenciaFuente(int potenciaFuente) {
        this.potenciaFuente = validarIntPositivo(potenciaFuente, "Potencia fuente");
    }

    public String getFactorForma() {
        return factorForma;
    }

    public void setFactorForma(String factorForma) {
        this.factorForma = validarStringObligatorio(factorForma, "Factor forma");
    }

    @Override
    public String toString() {
        return super.toString() + ", Potencia Fuente: " + potenciaFuente + ", Factor Forma: " + factorForma;
    }
}
