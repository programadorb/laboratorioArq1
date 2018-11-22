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
        <title>Información del Cliente</title>
         <nav role="navigation" class="navbar navbar-default">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="cliente.jsp">Clientes</a></li>
                <li><a href="vehiculo.jsp">Vehículos</a></li>
                <li><a href="vendedor.jsp">Vendedor</a></li>
                <li><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>INFORMACIÓN DEL CLIENTE</h1>

            
            
            <form action="./clienteServlet" method="POST">
                <table>
                    <tr>
                        <th>Cédula</th>
                        <th><br><input type="text" name="cedula" class="form-control" required="true" placeholder="Cédula" value="${cliente.cedula}"/> </th>
                    </tr>
                    <tr>
                        <th> Nombre</th>
                        <th><br><input type="text" name="Nombre" class="form-control" placeholder="Nombre" value="${cliente.nombre}"/></th>
                    </tr>
                    <tr>
                        <th>Apellido</th>
                        <th><br><input type="text" name="Apellido" class="form-control" placeholder="Apellido" value="${cliente.apellido}"/> </th>
                    </tr>
                    <tr>
                        <th>Dirección</th>
                        <th><br><input type="text" name="Direccion" class="form-control" placeholder="Dirección" value="${cliente.direccion}"/></th>
                    </tr>
                    <tr>
                        <th>Teléfono</th>
                        <th><br><input type="text" name="Telefono" class="form-control" placeholder="Teléfono" value="${cliente.telefono}"/></th>
                    </tr>                    
                    <tr>
                        <td  colspan="2"><br>
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
                        <th>Dirección</th>
                        <th>Teléfono</th>
                    </tr>
                </thead>
                <thead>
                <tr>
                    <c:choose>
                        <c:when test="${buscarTodo}">
                            <c:forEach items="${allClientes}" var="cliente">
                                 
                                <td>${cliente.cedula}</td>
                                <td>${cliente.nombre}</td>
                                <td>${cliente.apellido}</td>
                                <td>${cliente.direccion}</td>
                                <td>${cliente.telefono}</td>
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
                    <td>${message3}</td>
                    <td>${message4}</td>           
                </tr>
                </thead>
                    </table>
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
    </body>
</html>