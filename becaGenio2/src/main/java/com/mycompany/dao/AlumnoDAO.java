
package com.mycompany.dao;

import com.mycompany.config.Conexion;
import com.mycompany.modelo.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AlumnoDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;

    // Crear un objeto base
    private Alumno baseAlumno = new Alumno(); // Objeto base para clonar

    public ArrayList<Alumno> ListarTodos() {
        ArrayList<Alumno> lista = new ArrayList<>();
        
        try {
            cn = Conexion.getConnection();
            String sql = "{CALL ListarEstudiantes()}"; // Llama al procedimiento almacenado
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                // Clona el objeto base
                Alumno obj = (Alumno) baseAlumno.clone(); // Clona el objeto base
                
                // Ajusta los valores del objeto clonado
                obj.setId(rs.getInt("id"));
                obj.setDni(rs.getString("dni"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApellido_p(rs.getString("apellido_p"));
                obj.setApellido_m(rs.getString("apellido_m"));
                obj.setNivel(rs.getString("nivel"));
                obj.setGrado(rs.getString("grado"));
                obj.setPromedio(rs.getDouble("promedio"));
                
                lista.add(obj); // Agrega a la lista
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Cierre de conexiones
            try {
                if (cn != null) {
                    cn.close();
                }
                if (rs != null) {
                    rs.close();
                }        
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
            }
        }
        
        return lista;
    }
    
    public Alumno buscarPorDni(String dni){
        Alumno alumno = null;
        try {
            cn = Conexion.getConnection(); // usando singleton
            String sql = "{CALL buscarEstudiantePorDni(?)}";//llamando al procedure
            cs = cn.prepareCall(sql);
            cs.setString(1, dni);
            rs = cs.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setDni(rs.getString("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido_p(rs.getString("apellido_p"));
                alumno.setApellido_m(rs.getString("apellido_m"));
                alumno.setNivel(rs.getString("nivel"));
                alumno.setGrado(rs.getString("grado"));
                alumno.setPromedio(rs.getDouble("promedio"));                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }        
                if (cn != null) {
                    cn.close();
                }
            }catch(Exception ex){
            }
        }
        return alumno;
    }
}

