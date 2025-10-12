package com.computec.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Singleton para conexión con la Base de Datos
 */

public final class DatabaseConnection {
    // Instancia única de la clase
    private static DatabaseConnection instance = null;
    
    // Instancia de Connection
    private Connection connection;
    
    // Datos de conexión
    private final String URL = "jdbc:mysql://localhost:3306/computec_db?useSSL=false&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "123456789";
    
    // Constructor privado
    private DatabaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    // Método estático para obtener la instancia única
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            synchronized (DatabaseConnection.class) {
                if (instance == null || instance.getConnection().isClosed()) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    // Método que devuelve la conexión
    public Connection getConnection() {
        return connection;
    }
    
    public static String estadoConexion() {        
        try {
            if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
            return "¡Conexión exitosa con la Base de Datos!";
        } catch (SQLException e) {
            return "Ha ocurrido un problema al conectar con la Base de Datos: " + e.getMessage();
        }
    }
}
