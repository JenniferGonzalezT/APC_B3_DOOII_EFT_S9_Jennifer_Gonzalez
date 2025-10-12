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
        Cliente cliente = null;
        String sql = "{CALL sp_cliente_buscar_por_rut(?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {

            cs.setString(1, rut);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setRutCliente(rs.getString("rut_cliente"));
                    cliente.setNombreCompleto(rs.getString("nombre_completo"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setComuna(rs.getString("comuna"));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por RUT: " + e.getMessage());
        }
        return cliente;
    }
}
