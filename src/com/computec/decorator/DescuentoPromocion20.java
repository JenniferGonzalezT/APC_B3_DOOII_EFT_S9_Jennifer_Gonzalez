package com.computec.decorator;

import com.computec.modelo.Equipo;

public class DescuentoPromocion20 extends DescuentoBase {
    public DescuentoPromocion20(Descuento descuento) {
        super(descuento);
    }
    
    @Override
    public double aplicarDescuento(Equipo equipo) {
        return equipo.getPrecio() * 0.80;
    }
}
