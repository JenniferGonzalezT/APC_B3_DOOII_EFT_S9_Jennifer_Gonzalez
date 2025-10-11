package com.computec.dao;

import com.computec.modelo.Cliente;

import org.junit.*;
import java.util.List;

public class ClienteDAOTest {
    private static ClienteDAO clienteDAO;
    private static Cliente cliente;

    @BeforeClass
    public static void setUpBeforeClass() {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente("12345678-9", "Juan Perez", "Calle Falsa 123", "Santiago", "juan@mail.com", "912345678");
    }

    @Test
    public void testCrearCliente() {
        clienteDAO.insertar(cliente);
        List<Cliente> clientes = clienteDAO.listar();
        boolean existe = clientes.stream().anyMatch(c -> c.getRutCliente().equals(cliente.getRutCliente()));
        Assert.assertTrue("Cliente debe existir después de crearlo", existe);
    }

    @Test
    public void testActualizarCliente() {
        cliente.setNombreCompleto("Juan P. Actualizado");
        clienteDAO.actualizar(cliente);
        List<Cliente> clientes = clienteDAO.listar();
        Cliente actualizado = clientes.stream()
                .filter(c -> c.getRutCliente().equals(cliente.getRutCliente()))
                .findFirst()
                .orElse(null);
        Assert.assertNotNull(actualizado);
        Assert.assertEquals("Juan P. Actualizado", actualizado.getNombreCompleto());
    }

    @Test
    public void testEliminarCliente() {
        clienteDAO.eliminar(cliente.getRutCliente());
        List<Cliente> clientes = clienteDAO.listar();
        boolean existe = clientes.stream().anyMatch(c -> c.getRutCliente().equals(cliente.getRutCliente()));
        Assert.assertFalse("Cliente no debe existir después de eliminarlo", existe);
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
        try {
            clienteDAO.eliminar(cliente.getRutCliente());
        } catch (Exception ignored) {}
    }
}
