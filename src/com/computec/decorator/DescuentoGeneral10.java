package com.computec.decorator;

import com.computec.modelo.Equipo;

public class DescuentoGeneral10 extends DescuentoBase {
    public DescuentoGeneral10(Descuento descuento) {
        super(descuento);
    }
    
    @Override
    public double aplicarDescuento(Equipo equipo) {
        double precioBase = super.aplicarDescuento(equipo);
        return precioBase * 0.90;
    }
}
