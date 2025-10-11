package com.computec.controlador;

import com.computec.dao.VentaDAO;
import com.computec.modelo.Venta;
import java.util.List;

public class VentaControlador {
    private final VentaDAO dao = new VentaDAO();
    
    public void insertar(Venta venta) {
        dao.insertar(venta);
    }
    
    public List<Venta> listar() {
        return dao.listar();
    }
    
    public void actualizar(Venta venta) {
        dao.actualizar(venta);
    }
    
    public void eliminar(int idVenta) {
        dao.eliminar(idVenta);
    }
    
    public Venta buscarVentaPorId(int idVenta) {
        return dao.buscarVentaPorId(idVenta);
    }
}
