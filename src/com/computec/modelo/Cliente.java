package com.computec.modelo;

import java.util.regex.Pattern;

public class Cliente {
    private String rutCliente;
    private String nombreCompleto;
    private String direccion;
    private String comuna;
    private String correo;
    private String telefono;

    public Cliente() {}

    public Cliente(String rutCliente, String nombreCompleto, String direccion, 
            String comuna, String correo, String telefono) {
        this.rutCliente = validarRut(rutCliente);
        this.nombreCompleto = validarStringObligatorio(nombreCompleto, "nombre completo");
        this.direccion = validarStringObligatorio(direccion,"dirección");
        this.comuna = validarStringObligatorio(comuna, "comuna");
        this.correo = validarCorreo(correo);
        this.telefono = validarTelefono(telefono);
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = validarRut(rutCliente);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = validarStringObligatorio(nombreCompleto, "nombre completo");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = validarStringObligatorio(direccion,"dirección");
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = validarStringObligatorio(comuna, "comuna");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = validarCorreo(correo);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = validarTelefono(telefono);
    }

    @Override
    public String toString() {
        return rutCliente + " - " + nombreCompleto;
    }
    
    
    // Validaciones
    private static final Pattern RUT_PATTERN = Pattern.compile("^[0-9]{7,8}-[0-9Kk]$");
    private static final Pattern CORREO_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("^(\\+?56)?9\\d{8}$");

    private String validarStringObligatorio(String campo, String nombreCampo) {
        if (campo == null || campo.isBlank()) {
            throw new IllegalArgumentException("El campo " + nombreCampo + " no puede estar vacío.");
        }
        return campo.trim();
    }
    
    private String validarRut(String rut) {
        if (rut == null || rut.isBlank()) {
            throw new IllegalArgumentException("El RUT no puede estar vacío.");
        }
        
        if (!RUT_PATTERN.matcher(rut.trim()).matches()) {
            throw new IllegalArgumentException("El RUT no es válido. (Formato correcto: 12345678-9)");
        }
        
        return rut.trim();
    }
    
    private String validarCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El CORREO no puede estar vacío.");
        }
        
        if (!CORREO_PATTERN.matcher(correo.trim()).matches()) {
            throw new IllegalArgumentException("El CORREO no es válido. (Formato correcto: usuario@dominio.com)");
        }
        
        return correo.trim();
    }
    
    private String validarTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El TELÉFONO no puede estar vacío.");
        }
        
        if (!TELEFONO_PATTERN.matcher(telefono.trim()).matches()) {
            throw new IllegalArgumentException("El TELÉFONO no es válido. (Formatos correctos: 912345678, +56912345678, 56912345678)");
        }
        
        return telefono.trim();
    }
}
