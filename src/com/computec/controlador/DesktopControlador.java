package com.computec.controlador;

import com.computec.dao.DesktopDAO;
import com.computec.modelo.Desktop;
import java.util.List;

public class DesktopControlador {
    private final DesktopDAO dao = new DesktopDAO();
    
    public void insertar(Desktop desktop) {
        dao.insertar(desktop);
    }
    
    public List<Desktop> listar() {
        return dao.listar();
    }
    
    public void actualizar(Desktop desktop) {
        dao.actualizar(desktop);
    }
    
    public void eliminar(int idEquipo) {
        dao.eliminar(idEquipo);
    }
    
    public Desktop buscarDesktopPorId(int idEquipo) {
        return dao.buscarDesktopPorId(idEquipo);
    }
}
