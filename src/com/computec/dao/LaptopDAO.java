package com.computec.dao;

import com.computec.database.DatabaseConnection;
import com.computec.modelo.Categoria;
import com.computec.modelo.Laptop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO {
    public void insertar(Laptop laptop) {
        String sql = "{CALL sp_laptop_insertar(?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, laptop.getIdEquipo());
            cs.setDouble(2, laptop.getPantallaPulgadas());
            cs.setBoolean(3, laptop.isEsTouch());
            cs.setInt(4, laptop.getPuertosUsb());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear laptop: " + e.getMessage(), e);
        }
    }
    
    public List<Laptop> listar() {
        List<Laptop> laptops = new ArrayList<>();
        String sql = "{CALL sp_laptop_listar()}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Laptop l = new Laptop(
                        rs.getInt("id_equipo"),
                        rs.getString("modelo"),
                        rs.getString("cpu"),
                        rs.getInt("disco_duro_mb"),
                        rs.getInt("ram_gb"),
                        rs.getDouble("precio"),
                        Categoria.fromString(rs.getString("categoria")),
                        rs.getDouble("pantalla_pulgadas"),
                        rs.getBoolean("es_touch"),
                        rs.getInt("puertos_usb")
                );
                laptops.add(l);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar laptops: " + e.getMessage(), e);
        }

        return laptops;
    }
    
    public void actualizar(Laptop laptop) {
        String sql = "{CALL sp_laptop_actualizar(?, ?, ?, ?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, laptop.getIdEquipo());
            cs.setDouble(2, laptop.getPantallaPulgadas());
            cs.setBoolean(3, laptop.isEsTouch());
            cs.setInt(4, laptop.getPuertosUsb());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar laptop: " + e.getMessage(), e);
        }
    }
    
    public void eliminar(int idEquipo) {
        String sql = "{CALL sp_laptop_eliminar(?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {
            cs.setInt(1, idEquipo);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar laptop: " + e.getMessage(), e);
        }
    }
    
    public Laptop buscarLaptopPorId(int idEquipo) {
        Laptop laptop = null;
        String sql = "{CALL sp_laptop_buscar_por_id (?)}";

        try (CallableStatement cs = DatabaseConnection.getInstance().getConnection().prepareCall(sql)) {

            cs.setInt(1, idEquipo);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    laptop = new Laptop();
                    laptop.setIdEquipo(rs.getInt("id_equipo"));
                    laptop.setModelo(rs.getString("modelo"));
                    laptop.setCpu(rs.getString("cpu"));
                    laptop.setDiscoDuroMb(rs.getInt("disco_duro_mb"));
                    laptop.setRamGb(rs.getInt("ram_gb"));
                    laptop.setPrecio(rs.getDouble("precio"));
                    laptop.setCategoria(Categoria.fromString(rs.getString("categoria")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar ID Laptop: " + e.getMessage());
        }
        return laptop;
    }
}
