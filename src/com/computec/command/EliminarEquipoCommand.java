package com.computec.command;

import com.computec.controlador.EquipoControlador;

public class EliminarEquipoCommand implements Command {
    private final EquipoControlador equipoControlador;
    private final int idEquipo;

    public EliminarEquipoCommand(EquipoControlador equipoControlador, int idEquipo) {
        this.equipoControlador = equipoControlador;
        this.idEquipo = idEquipo;
    }

    @Override
    public void execute() {
        equipoControlador.eliminar(idEquipo);
    }
}
