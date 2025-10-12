package com.computec.app;

import com.computec.database.DatabaseConnection;
import com.computec.vista.MainJFrame;
import javax.swing.SwingUtilities;

/**
 * Aplicación desarrollada en Java y MySQL, con interfaz gráfica de Swing
 * Para llevar el control de las ventas de la empresa Computec
 * @author Jennifer
 */

public class Main {

    public static void main(String[] args) {
        // Probar la conexión con la base de datos
        //System.out.println(DatabaseConnection.estadoConexion());

        // Iniciar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MainJFrame ventana = new MainJFrame();
            ventana.setVisible(true);
        });
    }
}
