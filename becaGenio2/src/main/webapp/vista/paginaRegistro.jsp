
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO A BECAGENIO</title>
    </head>
    <body>
        <h1>Registro para el sistema de becas</h1>
        <form action="${pageContext.request.contextPath}/registroBeca" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required><br>

            <label for="apellido">Apellido:</label>
            <input type="text" name="apellido" required><br>

            <label for="dni">DNI:</label>
            <input type="text" name="dni" required><br>

            <label for="correo">Correo:</label>
            <input type="email" name="correo" required><br>

            <label for="contrasena">Contraseña:</label>
            <input type="password" name="contrasena" required><br>

            <input type="submit" value="Registrar">
        </form>

        <!-- Mostrar mensajes de éxito o error -->
        <% if (request.getAttribute("mensajeExito") != null) { %>
        <p style="color: green;"><%= request.getAttribute("mensajeExito") %></p>
        <% } else if (request.getAttribute("mensajeError") != null) { %>
        <p style="color: red;"><%= request.getAttribute("mensajeError") %></p>
        <% } %>

    </body>
</html>
