package com.computec.command;

import com.computec.dao.EquipoDAO;
import com.computec.modelo.Equipo;

public class AgregarEquipoCommand implements Command {
    private final EquipoDAO equipoDAO;
    private final Equipo equipo;

    public AgregarEquipoCommand(EquipoDAO equipoDAO, Equipo equipo) {
        this.equipoDAO = equipoDAO;
        this.equipo = equipo;
    }
    
    @Override
    public void execute() {
        equipoDAO.insertar(equipo);
    }
}
