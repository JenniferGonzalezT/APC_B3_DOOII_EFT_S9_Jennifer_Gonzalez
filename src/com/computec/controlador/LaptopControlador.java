package com.computec.controlador;

import com.computec.dao.LaptopDAO;
import com.computec.modelo.Laptop;
import java.util.List;

public class LaptopControlador {
    private final LaptopDAO dao = new LaptopDAO();
    
    public void insertar(Laptop laptop) {
        dao.insertar(laptop);
    }
    
    public List<Laptop> listar() {
        return dao.listar();
    }
    
    public void actualizar(Laptop laptop) {
        dao.actualizar(laptop);
    }
    
    public void eliminar(int idEquipo) {
        dao.eliminar(idEquipo);
    }
    
    public Laptop buscarLaptopPorId(int idEquipo) {
        return dao.buscarLaptopPorId(idEquipo);
    }
}
