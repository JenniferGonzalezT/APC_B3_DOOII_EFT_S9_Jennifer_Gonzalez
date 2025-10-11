package com.computec.command;

import com.computec.dao.EquipoDAO;
import com.computec.modelo.Equipo;
import java.util.List;

public class ListarEquiposCommand implements Command {
    private final EquipoDAO equipoDAO;

    public ListarEquiposCommand(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    @Override
    public void execute() {
        List<Equipo> equipos = equipoDAO.listar();
    }
}
