package com.computec.dao;

import com.computec.database.DatabaseConnection;
import com.computec.modelo.Categoria;
import com.computec.modelo.Equipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    public void insertar(Equipo equipo) {
        String sql = "{CALL sp_equipo_insertar(?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setString(1, equipo.getModelo());
            cs.setString(2, equipo.getCpu());
            cs.setInt(3, equipo.getDiscoDuroMb());
            cs.setInt(4, equipo.getRamGb());
            cs.setDouble(5, equipo.getPrecio());
            cs.setString(6, equipo.getCategoria().getNombre());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear equipo: " + e.getMessage(), e);
        }
    }
    
    public List<Equipo> listar() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "{CALL sp_equipo_listar()}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Equipo e = new Equipo(
                        rs.getInt("id_equipo"),
                        rs.getString("modelo"),
                        rs.getString("cpu"),
                        rs.getInt("disco_duro_mb"),
                        rs.getInt("ram_gb"),
                        rs.getDouble("precio"),
                        Categoria.fromString(rs.getString("categoria"))
                );
                equipos.add(e);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al listar equipos: " + ex.getMessage(), ex);
        }
        return equipos;
    }
    
    public void actualizar(Equipo equipo) {
        String sql = "{CALL sp_equipo_actualizar(?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, equipo.getIdEquipo());
            cs.setString(2, equipo.getModelo());
            cs.setString(3, equipo.getCpu());
            cs.setInt(4, equipo.getDiscoDuroMb());
            cs.setInt(5, equipo.getRamGb());
            cs.setDouble(6, equipo.getPrecio());
            cs.setString(7, equipo.getCategoria().getNombre());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar equipo: " + e.getMessage(), e);
        }
    }
    
    public void eliminar(int idEquipo) {
        String sql = "{CALL sp_equipo_eliminar(?)}";

        try (CallableStatement cs=  DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, idEquipo);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar equipo: " + e.getMessage(), e);
        }
    }
    
    public Equipo buscarEquipoPorId(int idEquipo) {
        for (Equipo e : listar()) {
            if (e.getIdEquipo() == idEquipo) {
                return e;
            }
        }
        return null;
    }
}
