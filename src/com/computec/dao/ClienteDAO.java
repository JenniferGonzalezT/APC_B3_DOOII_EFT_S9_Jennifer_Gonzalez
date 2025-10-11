package com.computec.dao;

import com.computec.database.DatabaseConnection;
import com.computec.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void insertar(Cliente cliente) {
        String sql = "{CALL sp_cliente_insertar(?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setString(1, cliente.getRutCliente());
            cs.setString(2, cliente.getNombreCompleto());
            cs.setString(3, cliente.getDireccion());
            cs.setString(4, cliente.getComuna());
            cs.setString(5, cliente.getCorreo());
            cs.setString(6, cliente.getTelefono());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear cliente: " + e.getMessage(), e);
        }
    }
    
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "{CALL sp_cliente_listar()}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getString("rut_cliente"),
                        rs.getString("nombre_completo"),
                        rs.getString("direccion"),
                        rs.getString("comuna"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );
                clientes.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar clientes: " + e.getMessage(), e);
        }
        return clientes;
    }
    
    public void actualizar(Cliente cliente) {
        String sql = "{CALL sp_cliente_actualizar(?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setString(1, cliente.getRutCliente());
            cs.setString(2, cliente.getNombreCompleto());
            cs.setString(3, cliente.getDireccion());
            cs.setString(4, cliente.getComuna());
            cs.setString(5, cliente.getCorreo());
            cs.setString(6, cliente.getTelefono());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cliente: " + e.getMessage(), e);
        }
    }
    
    public void eliminar(String rut) {
        String sql = "{CALL sp_cliente_eliminar(?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setString(1, rut);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cliente: " + e.getMessage(), e);
        }
    }
    
    public Cliente buscarClientePorRut(String rut) {
        List<Cliente> clientes = listar();
        for (Cliente c : clientes) {
            if (c.getRutCliente().equalsIgnoreCase(rut)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> buscarClientesPorNombre(String nombre) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente c : listar()) {
            if (c.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
