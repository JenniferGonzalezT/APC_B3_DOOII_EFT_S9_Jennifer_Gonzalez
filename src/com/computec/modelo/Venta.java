package com.computec.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venta {
    private int idVenta;
    private Cliente cliente;
    private Equipo equipo;
    private LocalDateTime fechaVenta;
    
    public Venta() {}
    
    public Venta(Cliente cliente, Equipo equipo, LocalDateTime fechaVenta) {
        this.cliente = validarCliente(cliente);
        this.equipo = validarEquipo(equipo);
        this.fechaVenta = validarFecha(fechaVenta);
    }

    public Venta(int idVenta, Cliente cliente, Equipo equipo, LocalDateTime fechaVenta) {
        this.idVenta = idVenta;
        this.cliente = validarCliente(cliente);
        this.equipo = validarEquipo(equipo);
        this.fechaVenta = validarFecha(fechaVenta);
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = validarCliente(cliente);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = validarEquipo(equipo);
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = validarFecha(fechaVenta);
    }
    
    // Formato fecha
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public String toString() {
        return "Venta #" + idVenta + " - Cliente: " + cliente + " - Equipo: " + equipo + " - Fecha Venta: " + fechaVenta.format(FORMATTER);
    }
    
    // Validaciones
    private Cliente validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        return cliente;
    }

    private Equipo validarEquipo(Equipo equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("El equipo no puede ser nulo.");
        }
        return equipo;
    }

    private LocalDateTime validarFecha(LocalDateTime fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha de la venta no puede ser nula.");
        }
        if (fecha.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la venta no puede ser futura.");
        }
        return fecha;
    }
}
