package com.computec.database;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {
    // Test para verificar que exista una instancia de la conexión
    @Test
    public void unicaInstancia() throws SQLException {
    // Obtenemos la conexión dos veces
    Connection c1 = DatabaseConnection.getInstance().getConnection();
    Connection c2 = DatabaseConnection.getInstance().getConnection();

    assertSame("Misma conexión por instancia única", c1, c2);
    }

    // Test para verificar que la conexión existe y está disponible
    @Test
    public void conexion_noEsNula_y_noEstaCerrada() throws SQLException {
    Connection c = DatabaseConnection.getInstance().getConnection();

    assertNotNull("Conexión no nula",c);

    assertFalse("Conexión no cerrada", c.isClosed());
    }

    // Test para verificar la ejecución de consultas SQL
    @Test
    public void verificarConexionBD() throws SQLException {
    try (Statement st = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT 1")) {
        
        assertTrue("SELECT 1 debe devolver una fila", rs.next());

        assertEquals(1, rs.getInt(1));
    }
  }
}
