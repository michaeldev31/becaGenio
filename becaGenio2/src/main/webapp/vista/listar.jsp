<%-- 
    Document   : listar
    Created on : 11 oct 2024, 0:59:05
    Author     : micha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido p</th>
                    <th>Apellido m</th>
                    <th>Nivel</th>
                    <th>Grado</th>
                    <th>Promedio</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${alumnos}" var="item">
                    <tr>
                        <th>${item.id}</th>
                        <th>${item.nombre}</th>
                        <th>${item.apellido_p}</th>
                        <th>${item.apellido_m}</th>
                        <th>${item.nivel}</th>
                        <th>${item.grado}</th>
                        <th>${item.promedio}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
