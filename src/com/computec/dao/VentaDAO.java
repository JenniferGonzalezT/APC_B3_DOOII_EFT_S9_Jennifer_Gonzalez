package com.computec.dao;

import com.computec.database.DatabaseConnection;
import com.computec.modelo.Cliente;
import com.computec.modelo.Equipo;
import com.computec.modelo.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    public void insertar(Venta venta) {
        String sql = "{CALL sp_venta_insertar(?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setString(1, venta.getCliente().getRutCliente());
            cs.setInt(2, venta.getEquipo().getIdEquipo());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear venta: " + e.getMessage(), e);
        }
    }
    
    public List<Venta> listar() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "{CALL sp_venta_listar()}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNombreCompleto(rs.getString("cliente"));
                cliente.setRutCliente(rs.getString("rut_cliente"));

                Equipo equipo = new Equipo();
                equipo.setModelo(rs.getString("equipo"));
                equipo.setPrecio(rs.getDouble("precio"));

                Venta venta = new Venta(
                        cliente,
                        equipo,
                        rs.getTimestamp("fecha_venta").toLocalDateTime()
                );
                venta.setIdVenta(rs.getInt("id_venta"));

                ventas.add(venta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar ventas: " + e.getMessage(), e);
        }
        return ventas;
    }
    
    public void actualizar(Venta venta) {
        String sql = "{CALL sp_venta_actualizar(?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, venta.getIdVenta());
            cs.setString(2, venta.getCliente().getRutCliente());
            cs.setInt(3, venta.getEquipo().getIdEquipo());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar venta: " + e.getMessage(), e);
        }
    }
    
    public void eliminar(int idVenta) {
        String sql = "{CALL sp_venta_eliminar(?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, idVenta);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar venta: " + e.getMessage(), e);
        }
    }
    
    public Venta buscarVentaPorId(int idVenta) {
        Venta venta = null;
        String sql = "{CALL sp_venta_buscar_por_id (?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {

            cs.setInt(1, idVenta);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNombreCompleto(rs.getString("cliente"));
                    cliente.setRutCliente(rs.getString("rut_cliente"));

                    Equipo equipo = new Equipo();
                    equipo.setModelo(rs.getString("equipo"));
                    equipo.setPrecio(rs.getDouble("precio"));

                    venta = new Venta(
                            cliente,
                            equipo,
                            rs.getTimestamp("fecha_venta").toLocalDateTime()
                    );
                    venta.setIdVenta(rs.getInt("id_venta"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar ID Venta: " + e.getMessage());
        }
        return venta;
    }
}
