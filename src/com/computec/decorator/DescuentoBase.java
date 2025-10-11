package com.computec.decorator;

import com.computec.modelo.Equipo;

/**
 * Clase decorador abstracta que es la base para los decoradores.
 */

public abstract class DescuentoBase implements Descuento {
    protected Descuento descuento;

    public DescuentoBase(Descuento descuento) {
        this.descuento = descuento;
    }
    
    @Override
    public double aplicarDescuento(Equipo equipo) {
        return equipo.getPrecio();
    }
}
