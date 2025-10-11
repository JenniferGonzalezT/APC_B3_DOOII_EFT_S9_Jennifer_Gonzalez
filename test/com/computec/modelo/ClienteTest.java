package com.computec.modelo;

import com.computec.modelo.Cliente;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {
    // Test para verificar la creación de un cliente
    @Test
    public void crearClienteValido() {
        Cliente c = new Cliente(
            "12345678-9",
            "Juan Pérez",
            "Av. Siempre Viva 742",
            "Santiago",
            "juan.perez@mail.com",
            "+56912345678"
        );
        assertEquals("12345678-9", c.getRutCliente());
        assertEquals("Juan Pérez", c.getNombreCompleto());
    }

    // Verificar el lanzamiento de excepciones
    @Test(expected = IllegalArgumentException.class)
    public void rutVacio_Excepcion() {
        new Cliente("", "Juan Pérez", "Dir", 
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rutNulo_Excepcion() {
        new Cliente(null, "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rutSinGuion_Excepcion() {
        new Cliente("123456789", "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rutConLetras_Excepcion() {
        new Cliente("ABC45678-9", "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void correoInvalido_Excepcion() {
        new Cliente("12345678-9", "Juan Pérez", "Dir",
                "Comuna", "juanperezmail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void telefonoInvalido_Excepcion() {
        new Cliente("12345678-9", "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "12345");
    }

    @Test
    public void telefonoFormatosValidos() {
        Cliente c1 = new Cliente("12345678-9", "Juan Pérez", "Dir", 
                "Comuna", "mail@mail.com", "912345678");
        Cliente c2 = new Cliente("12345678-9", "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "56912345678");
        Cliente c3 = new Cliente("12345678-9", "Juan Pérez", "Dir",
                "Comuna", "mail@mail.com", "+56912345678");
        
        assertNotNull(c1);
        assertNotNull(c2);
        assertNotNull(c3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nombreVacio_Excepcion() {
        new Cliente("12345678-9", "", "Dir",
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void direccionVacia_Excepcion() {
        new Cliente("12345678-9", "Juan Pérez", "",
                "Comuna", "mail@mail.com", "912345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void comunaVacia_Excepcion() {
        new Cliente("12345678-9", "Juan Pérez", "Dir",
                "", "mail@mail.com", "912345678");
    }    
}
