package com.computec.command;

import com.computec.controlador.EquipoControlador;
import com.computec.modelo.Equipo;

public class EditarEquipoCommand implements Command {
    private final EquipoControlador equipoControlador;
    private final Equipo equipo;

    public EditarEquipoCommand(EquipoControlador equipoControlador, Equipo equipo) {
        this.equipoControlador = equipoControlador;
        this.equipo = equipo;
    }

    @Override
    public void execute() {
        equipoControlador.actualizar(equipo);
    }
}
