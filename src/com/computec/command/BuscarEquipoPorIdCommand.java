package com.computec.command;

import com.computec.controlador.EquipoControlador;
import com.computec.modelo.Equipo;

public class BuscarEquipoPorIdCommand implements Command {
    private final EquipoControlador equipoControlador;
    private final int id;
    private Equipo resultado;

    public BuscarEquipoPorIdCommand(EquipoControlador equipoControlador, int id) {
        this.equipoControlador = equipoControlador;
        this.id = id;
    }

    @Override
    public void execute() {
        resultado = equipoControlador.buscarEquipoPorId(id);
    }

    public Equipo getResultado() {
        return resultado;
    }
}
