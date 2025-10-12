package com.computec.decorator;

import com.computec.modelo.Categoria;
import com.computec.modelo.Equipo;
import org.junit.*;

public class DescuentoTest {
    private Equipo equipoBase;

    @Before
    public void setUp() {
        equipoBase = new Equipo("ModeloTest", "Intel i5", 500000, 16, 1000.0, Categoria.fromString("LAPTOP"));
    }

    @Test
    public void testSinDescuento() {
        Descuento sinDescuento = new DescuentoBase(null) {};
        double precio = sinDescuento.aplicarDescuento(equipoBase);
        Assert.assertEquals(1000.0, precio, 0.001);
    }

    @Test
    public void testDescuento10() {
        Descuento descuento10 = new DescuentoGeneral10(null);
        double precioFinal = descuento10.aplicarDescuento(equipoBase);
        Assert.assertEquals(900.0, precioFinal, 0.001);
    }

    @Test
    public void testDescuento20() {
        Descuento descuento20 = new DescuentoPromocion20(null);
        double precioFinal = descuento20.aplicarDescuento(equipoBase);
        Assert.assertEquals(800.0, precioFinal, 0.001);
    }

    @Test
    public void testDescuentosEncadenados10y20() {
        Descuento descuentoEncadenado = new DescuentoGeneral10(
                                            new DescuentoPromocion20(null));
        double precioFinal = descuentoEncadenado.aplicarDescuento(equipoBase);
        Assert.assertEquals(720.0, precioFinal, 0.001);
    }

    @Test
    public void testDescuentosEncadenados20y10() {
        Descuento descuentoEncadenado = new DescuentoPromocion20(
                                            new DescuentoGeneral10(null));
        double precioFinal = descuentoEncadenado.aplicarDescuento(equipoBase);
        Assert.assertEquals(720.0, precioFinal, 0.001);
    }
}
