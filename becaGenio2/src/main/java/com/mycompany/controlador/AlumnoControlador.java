package com.mycompany.controlador;

import com.mycompany.dao.AlumnoDAO;
import com.mycompany.modelo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "AlumnoControlador", urlPatterns = {"/AlumnoControlador"})
public class AlumnoControlador extends HttpServlet {

    //private AlumnoDAO almDao = new AlumnoDAO();
    private final String pagListar = "/vista/listar.jsp";
    private final String paginaResultado = "/vista/resultado.jsp";
    private final String paginaError = "/vista/error.jsp";

    //Metodo privaado que actúa como Factory para crear AlumnoDAO
    private AlumnoDAO getAlumnoDAO() {
        return new AlumnoDAO(); //retorna una nueva instancia de AlumnoDAO
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "buscarPorDni":
                buscarPorDni(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Usamos Factory para obtener la instancia de AlumnoDAO
        AlumnoDAO almDao = getAlumnoDAO();
        request.setAttribute("alumnos", almDao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

  
    protected void buscarPorDni(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Limpiar la sesión antes de la nueva búsqueda
        HttpSession session = request.getSession();
        session.removeAttribute("alumnoEncontrado");

        // Obtener el DNI ingresado
        String dni = request.getParameter("dni");
        System.out.println("Buscando alumno con DNI: " + dni); // Debugging

        // Obtener el DAO del alumno y buscar por DNI
        AlumnoDAO almDao = getAlumnoDAO();
        Alumno alumno = almDao.buscarPorDni(dni);

        if (alumno != null) {
            // Si el alumno existe, mandamos sus datos a la página de resultados
            System.out.println("Alumno encontrado: " + alumno); // Debugging

            // Aquí imprimimos el promedio para verificar que es correcto
            double promedio = alumno.getPromedio();
            System.out.println("Promedio del alumno: " + promedio); // Debugging

            // Validar si el alumno puede acceder a la beca (promedio >= 16)
            boolean puedeAccederBeca = promedio >= 16.0;
            request.setAttribute("puedeAccederBeca", puedeAccederBeca);

            // Pasamos los datos del alumno a la página de resultado
            request.setAttribute("alumno", alumno);
            request.getRequestDispatcher(paginaResultado).forward(request, response);
        } else {
            // Si no se encuentra el alumno, mandamos un mensaje de error
            System.out.println("No se encontró alumno con DNI: " + dni); // Debugging
            request.setAttribute("mensajeError", "El alumno con DNI " + dni + " no se encuentra en la base de datos.");
            request.getRequestDispatcher(paginaError).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
