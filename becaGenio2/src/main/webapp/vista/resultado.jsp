
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        
       
        <h1>Resultado de Búsquedad</h1>
        <h2>Información del Alumno</h2>
        <p>DNI: ${alumno.dni}</p>
        <p>Nombres y Apellidos: ${alumno.nombre} ${alumno.apellido_p} ${alumno.apellido_m}</p>
        <p>Nivel: ${alumno.grado}</p>
        <p>Grado: ${alumno.grado}</p>
        <p>Promedio: ${alumno.promedio}</p>
        
    <!-- Mostrar el botón solo si puedeAccederBeca es true -->
    
    <% Boolean puedeAccederBeca = (Boolean) request.getAttribute("puedeAccederBeca");%>
    <% if (puedeAccederBeca != null && puedeAccederBeca) { %>
        <a href="vista/paginaRegistro.jsp">Registrate aquí</a>
    <% } %>
     
    <br> 
    
    <a href="index.jsp">Regresar al inicio</a>
        
    </body>
</html>
