package com.computec.decorator;

import com.computec.modelo.Equipo;

public class DescuentoPromocion20 extends DescuentoBase {
    public DescuentoPromocion20(Descuento descuento) {
        super(descuento);
    }
    
    @Override
    public double aplicarDescuento(Equipo equipo) {
        double precioBase = super.aplicarDescuento(equipo);
        return precioBase * 0.80;
    }
}
