package com.computec.controlador;

import com.computec.dao.EquipoDAO;
import com.computec.modelo.Equipo;
import java.util.List;

public class EquipoControlador {
    private final EquipoDAO dao = new EquipoDAO();
    
    public void insertar(Equipo equipo) {
        dao.insertar(equipo);
    }
    
    public List<Equipo> listar() {
        return dao.listar();
    }
    
    public void actualizar(Equipo equipo) {
        dao.actualizar(equipo);
    }
    
    public void eliminar(int idEquipo) {
        dao.eliminar(idEquipo);
    }
    
    public Equipo buscarEquipoPorId(int idEquipo) {
        return dao.buscarEquipoPorId(idEquipo);
    }
}
