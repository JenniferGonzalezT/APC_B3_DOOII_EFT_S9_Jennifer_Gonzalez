package com.computec.controlador;

import com.computec.dao.ClienteDAO;
import com.computec.modelo.Cliente;
import java.util.List;

public class ClienteControlador {
    private final ClienteDAO dao = new ClienteDAO();
    
    public void insertar(Cliente cliente) {
        dao.insertar(cliente);
    }
    
    public List<Cliente> listar() {
        return dao.listar();
    }
    
    public void actualizar(Cliente cliente) { 
        dao.actualizar(cliente);
    }
    
    public void eliminar(String rut) {
        dao.eliminar(rut);
    }
    
    public Cliente buscarClientePorRut(String rut) {
        return dao.buscarClientePorRut(rut);
    }
    
    public List<Cliente> buscarClientesPorNombre(String nombre) {
        return dao.buscarClientesPorNombre(nombre);
    }
}
