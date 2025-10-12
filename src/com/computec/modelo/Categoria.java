package com.computec.modelo;

public enum Categoria {
    DESKTOP("DESKTOP"),
    LAPTOP("LAPTOP");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static Categoria fromString(String nombre) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.nombre.equalsIgnoreCase(nombre)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoría no válida: " + nombre);
    }
}
