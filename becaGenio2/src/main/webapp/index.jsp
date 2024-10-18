<%-- 
    Document   : index
    Created on : 11 oct 2024, 0:55:39
    Author     : micha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h1>Consultar si estas apto para la beca</h1>
        <form action="AlumnoControlador" method="POST">
            <input type="hidden"  name="accion" value="buscarPorDni">
            DNI: <input type="text" name="dni" required><br><br>
            <input type="submit"  value="Buscar">
        </form>
        <%--
        <%
        response.sendRedirect("AlumnoControlador?accion=listar");
        %>
        --%>
    </body>
</html>
