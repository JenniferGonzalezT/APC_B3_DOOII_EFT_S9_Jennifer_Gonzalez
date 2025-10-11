package com.computec.command;

import com.computec.controlador.EquipoControlador;
import com.computec.modelo.Equipo;
import java.util.List;

public class ListarEquiposCommand implements Command {
    private final EquipoControlador equipoControlador;

    public ListarEquiposCommand(EquipoControlador equipoControlador) {
        this.equipoControlador = equipoControlador;
    }

    @Override
    public void execute() {
        List<Equipo> equipos = equipoControlador.listar();
    }
}
