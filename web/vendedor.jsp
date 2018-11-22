<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://bootswatch.com/darkly/bootstrap.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Información del Vendedor</title>
         <nav role="navigation" class="navbar navbar-default">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="cliente.jsp">Clientes</a></li>
                <li ><a href="vehiculo.jsp">Vehiculos</a></li>
                <li class="active"><a href="vendedor.jsp">Vendedor</a></li>
                <li><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>INFORMACIÓN DEL VENDEDOR</h1>

            <form action="./vendedorServlet" method="POST">
                <table>
                    <tr>
                        <th>Cédula</th>
                        <th><br><input type="text" name="cedula" class="form-control" required="true" placeholder="Cédula" value="${vendedor.cedula}"/> </th>
                    </tr>
                    <tr>
                        <th>Nombre</th>
                        <th><br><input type="text" name="nombre" class="form-control" placeholder="Nombre" value="${vendedor.nombre}"/></th>
                    </tr>
                    <tr>
                        <th>Apellido</th>
                        <th><br><input type="text" name="apellido" class="form-control" placeholder="Apellido" value="${vendedor.apellido}"/> </th>
                    </tr>
                    <tr>
                        <td colspan="2"><br>
                            <input class="btn btn-primary" type="submit" name="action" value="Agregar"/>
                            <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"/>
                            <input class="btn btn-primary" type="submit" name="action" value="Editar"/>
                            <span class="glyphicon btn-glyphicon glyphicon-share img-circle text-info"/>
                            <input class="btn btn-primary" type="submit" name="action" value="Borrar"/>
                             <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"/>
                            <input class="btn btn-primary" type="submit" name="action" value="Buscar"/>
                            <span class="glyphicon btn-glyphicon glyphicon-search img-circle text-primary"/>
                            <input class="btn btn-primary" type="submit" name="action" value="BuscarTodos"/>
                            <span class="glyphicon btn-glyphicon glyphicon-search img-circle text-primary"/>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <table class="table table-inverse">
                <thead>
                    <tr class="info">
                        <th>Cédula</th>
                        <th>Nombre</th>
                        <th>Apellido</th>  
                    </tr>
                </thead>
                
               <thead>
                <tr>
                    <c:choose>
                        <c:when test="${buscarTodo}">
                            <c:forEach items="${allVendedor}" var="vend">
                                <td>${vend.cedula}</td>
                                <td>${vend.nombre}</td>
                                <td>${vend.apellido}</td>
                            </tr>
               </thead>
                        </c:forEach>
                    </c:when>
                    <c:otherwise> 
                        <thead>
                        <tr>
                            <td>${message}</td>
                            <td>${message1}</td>
                            <td>${message2}</td>  
                        </tr>
                        </thead>
                        <c:choose>
                        <c:when test="${controlMensaje}">
                            <div class="alert alert-warning">
                                <strong>MENSAJE: </strong> ${mensaje}
                            </div>
                        </c:when>
                    </c:choose>​
                    </c:otherwise>
                </c:choose>
        </div>
    </body