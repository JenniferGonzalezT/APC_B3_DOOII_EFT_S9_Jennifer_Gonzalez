package com.computec.command;

import com.computec.dao.EquipoDAO;

public class EliminarEquipoCommand implements Command {
    private final EquipoDAO equipoDAO;
    private final int idEquipo;

    public EliminarEquipoCommand(EquipoDAO equipoDAO, int idEquipo) {
        this.equipoDAO = equipoDAO;
        this.idEquipo = idEquipo;
    }

    @Override
    public void execute() {
        equipoDAO.eliminar(idEquipo);
    }
}
