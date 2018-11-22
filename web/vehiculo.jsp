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
        <title>Información del Vehículo</title>
         <nav role="navigation" class="navbar navbar-default">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="cliente.jsp">Clientes</a></li>
                <li class="active"><a href="vehiculo.jsp">Vehículos</a></li>
                <li><a href="vendedor.jsp">Vendedor</a></li>
                <li><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>INFORMACIÓN DEL VEHÍCULO</h1>

            <form action="./vehiculoServlet" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <th>Matrícula</th>
                        <th><br><input type="text" name="matricula" class="form-control" required="true" placeholder="Matrícula" value="${vehiculo.matricula}"/> </th>
                    </tr>
                    <tr>
                        <th>Marca</th>
                        <th><br><input type="text" name="marca" class="form-control" placeholder="Marca" value="${vehiculo.marca}"/></th>
                    </tr>
                    <tr>
                        <th>Modelo</th>
                        <th><br><input type="text" name="modelo" class="form-control" placeholder="Modelo" value="${vehiculo.modelo}"/> </th>
                    </tr>
                    <tr>
                        <th>Color</th>
                        <th><br><input type="text" name="color" class="form-control" placeholder="Color" value="${vehiculo.color}"/></th>
                    </tr>
                    <tr>
                        <th>Precio en millones:   </th>
                        <th><br><input type="text" name="precio" class="form-control" placeholder="Precio" value="${vehiculo.precio}"/></th>
                    </tr>
                     <tr>
                        <th>Foto</th>
                        <th><br><input type="file" name="foto" size="50" </th>
                    </tr>  
                    
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
                    <th>Matrícula</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Color</th>
                    <th>Precio</th>
                    <th>Foto</th>
                </tr>
                </thead>
                <thead>
                <tr>
                    <c:choose>
                        <c:when test="${buscarTodo}">
                            <c:forEach items="${allVehiculos}" var="veh">
                                <td>${veh.matricula}</td>
                                <td>${veh.marca}</td>
                                <td>${veh.modelo}</td>
                                <td>${veh.color}</td>
                                <td>${veh.precio}</td>
                                <td> <img src="/concesionario/vehiculoServlet?code=1&matricula=${veh.matricula}"height="150" width="250"/></td> 
                            </tr>
                </thead>
                        </c:forEach>
                    </c:when>
                    <c:otherwise> 
                        <c:if test="${message !=null}">
                            <thead>
                            <tr>                
                                <td> ${message}</td>
                                <td>${message1}</td>
                                <td>${message2}</td>
                                <td>${message3}</td>
                                <td>${message4}</td>
                                <td> <img src="/concesionario/vehiculoServlet?code=1&matricula=${message}"height="150" width="250"/></td>                  
                            </tr>
                            </thead>
                        </c:if>
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