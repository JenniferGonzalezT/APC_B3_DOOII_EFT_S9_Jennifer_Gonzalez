package com.computec.modelo;

public class Equipo {
    private int idEquipo;
    private String modelo;
    private String cpu;
    private int discoDuroMb;
    private int ramGb;
    private double precio;
    private String categoria;

    public Equipo() {}

    public Equipo(String modelo, String cpu, int discoDuroMb, int ramGb, double precio, String categoria) {
        this.modelo = validarStringObligatorio(modelo, "modelo");
        this.cpu = validarStringObligatorio(cpu, "CPU");
        this.discoDuroMb = validarIntPositivo(discoDuroMb, "Tamaño disco duro");
        this.ramGb = validarIntPositivo(ramGb, "RAM");
        this.precio = validarPrecio(precio);
        this.categoria = validarCategoria(categoria);
    }
    
    public Equipo(int idEquipo, String modelo, String cpu, int discoDuroMb, 
            int ramGb, double precio, String categoria) {
        this.idEquipo = idEquipo;
        this.modelo = validarStringObligatorio(modelo,"modelo");
        this.cpu = validarStringObligatorio(cpu, "CPU");
        this.discoDuroMb = validarIntPositivo(discoDuroMb, "Tamaño disco duro");
        this.ramGb = validarIntPositivo(ramGb, "RAM");
        this.precio = validarPrecio(precio);
        this.categoria = validarCategoria(categoria);
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = validarStringObligatorio(modelo, "modelo");
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = validarStringObligatorio(cpu, "CPU");
    }

    public int getDiscoDuroMb() {
        return discoDuroMb;
    }

    public void setDiscoDuroMb(int discoDuroMb) {
        this.discoDuroMb = validarIntPositivo(discoDuroMb, "Disco duro");
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = validarIntPositivo(ramGb, "RAM");
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = validarPrecio(precio);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = validarCategoria(categoria);
    }

    @Override
    public String toString() {
        return "Equipo #" + idEquipo + ", Modelo: " + modelo + ", CPU: " + cpu + ", Disco duro (MB): " + discoDuroMb + ", RAM (Gb): " + ramGb + ", Precio: " + precio + ", Categoría: " + categoria;
    }
    
    // Validaciones
    protected String validarStringObligatorio(String campo, String nombreCampo) {
        if (campo == null || campo.isBlank()) {
            throw new IllegalArgumentException("El campo " + nombreCampo + " no puede estar vacío.");
        }
        return campo.trim();
    }
    
    private double validarPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        return precio;
    }
    
    protected int validarIntPositivo(int numero, String nombreNumero) {
        if (numero <= 0) {
            throw new IllegalArgumentException(nombreNumero + " debe ser mayor que cero.");
        }
        return numero;
    }
    
    protected double validarDoublePositivo(double numero, String nombreNumero) {
    if (numero <= 0) {
        throw new IllegalArgumentException(nombreNumero + " debe ser mayor que cero.");
    }
    return numero;
    }
    
    private String validarCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
        
        String c = categoria.trim().toUpperCase();
        if (!c.equals("DESKTOP") && !c.equals("LAPTOP")) {
            throw new IllegalArgumentException("La categoría no es válida.");
        }
        return c;
    }
}
