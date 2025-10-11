package com.computec.command;

import com.computec.dao.EquipoDAO;
import com.computec.modelo.Equipo;

public class AgregarEquipoCommand implements Command {
    private final EquipoDAO equipoControlador;
    private final Equipo equipo;

    public AgregarEquipoCommand(EquipoDAO equipoControlador, Equipo equipo) {
        this.equipoControlador = equipoControlador;
        this.equipo = equipo;
    }
    
    @Override
    public void execute() {
        equipoControlador.insertar(equipo);
    }
}
