package com.computec.decorator;

import com.computec.modelo.Equipo;

/**
 * Interfaz Descuento con métodos comunes para los descuentos
 * usando patrón de diseño Decorator.
 */

public interface Descuento {
    double aplicarDescuento(Equipo equipo);
}
