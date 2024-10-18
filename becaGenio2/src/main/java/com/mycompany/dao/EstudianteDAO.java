
package com.mycompany.dao;

import com.mycompany.config.Conexion;
import com.mycompany.modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author micha
 */
public class EstudianteDAO {
    
    private Conexion conexion;
    
    public EstudianteDAO() {
        this.conexion = new Conexion();
    }

    public void agregarNuevoAlumnoBeca(Estudiante estudiante) throws SQLException {
        String query = "{CALL agregarNuevoAlumnoBeca(?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado

        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Pasar los parámetros al procedimiento almacenado
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getDni());
            stmt.setString(4, estudiante.getCorreo());
            stmt.setString(5, estudiante.getContrasena());

            stmt.executeUpdate(); // Ejecutar la consulta
        } catch (SQLException e) {
            throw new SQLException("Error al registrar el alumno: " + e.getMessage());
        }
    }
    
}
