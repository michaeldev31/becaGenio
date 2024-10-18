
package com.mycompany.controlador;

import com.mycompany.dao.EstudianteDAO;
import com.mycompany.modelo.Estudiante;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author micha
 */
@WebServlet("/registroBeca")
public class EstudianteControlador extends HttpServlet {
    
    private EstudianteDAO estudianteDAO;
    
    @Override
    public void init() {
        estudianteDAO = new EstudianteDAO(); // Inicializamos el DAO
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // Obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // Crear un objeto Estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, dni, correo, contrasena);

        // Intentar registrar al estudiante
        try {
            estudianteDAO.agregarNuevoAlumnoBeca(estudiante);
            request.setAttribute("mensajeExito", "Registro exitoso");
        } catch (SQLException e) {
            request.setAttribute("mensajeError", "Error al registrar: " + e.getMessage());
        }

        // Redirigir a la página de registro con el mensaje correspondiente
        request.getRequestDispatcher("vista/paginaRegistro.jsp").forward(request, response);
    }
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
