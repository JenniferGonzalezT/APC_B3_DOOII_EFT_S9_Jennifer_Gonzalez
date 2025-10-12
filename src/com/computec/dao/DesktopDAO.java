package com.computec.dao;

import com.computec.database.DatabaseConnection;
import com.computec.modelo.Categoria;
import com.computec.modelo.Desktop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DesktopDAO {
    public void insertar(Desktop desktop) {
        String sql = "{CALL sp_desktop_insertar(?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, desktop.getIdEquipo());
            cs.setInt(2, desktop.getPotenciaFuente());
            cs.setString(3, desktop.getFactorForma());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear desktop: " + e.getMessage(), e);
        }
    }
    
    public List<Desktop> listar() {
        List<Desktop> desktops = new ArrayList<>();
        String sql = "{CALL sp_desktop_listar()}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Desktop d = new Desktop(
                        rs.getInt("id_equipo"),
                        rs.getString("modelo"),
                        rs.getString("cpu"),
                        rs.getInt("disco_duro_mb"),
                        rs.getInt("ram_gb"),
                        rs.getDouble("precio"),
                        Categoria.fromString(rs.getString("categoria")),
                        rs.getInt("potencia_fuente"),
                        rs.getString("factor_forma")
                );
                desktops.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar desktops: " + e.getMessage(), e);
        }
        return desktops;
    }

    public void actualizar(Desktop desktop) {
        String sql = "{CALL sp_desktop_actualizar(?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, desktop.getIdEquipo());
            cs.setInt(2, desktop.getPotenciaFuente());
            cs.setString(3, desktop.getFactorForma());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar desktop: " + e.getMessage(), e);
        }
    }
    
    public void eliminar(int idEquipo) {
        String sql = "{CALL sp_desktop_eliminar(?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, idEquipo);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar desktop: " + e.getMessage(), e);
        }
    }
    
    public Desktop buscarDesktopPorId(int idEquipo) {
        Desktop desktop = null;
        String sql = "{CALL sp_desktop_buscar_por_id (?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {

            cs.setInt(1, idEquipo);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    desktop = new Desktop();
                    desktop.setIdEquipo(rs.getInt("id_equipo"));
                    desktop.setModelo(rs.getString("modelo"));
                    desktop.setCpu(rs.getString("cpu"));
                    desktop.setDiscoDuroMb(rs.getInt("disco_duro_mb"));
                    desktop.setRamGb(rs.getInt("ram_gb"));
                    desktop.setPrecio(rs.getDouble("precio"));
                    desktop.setCategoria(Categoria.fromString(rs.getString("categoria")));
                    desktop.setPotenciaFuente(rs.getInt("potencia_fuente"));
                    desktop.setFactorForma(rs.getString("factor_forma"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar ID Desktop: " + e.getMessage());
        }
        return desktop;
    }
}
