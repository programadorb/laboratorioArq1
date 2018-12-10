<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Información del Vehículo</title>
         <nav role="navigation" class="navbar">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="cliente.jsp">Clientes</a></li>
                <li class="active"><a href="vehiculo.jsp">Vehículos</a></li>
                <li><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>VEHÍCULO</h1>

            <form action="./VehiculoServlet" method="POST">
                <div class="col-lg-12">
                    <div class="col-lg-3">
                        Matrícula:<input type="text" name="matricula" class="form-control" placeholder="Matrícula" value="${vehiculo.matricula}"/>
                    </div>
                    <div class="col-lg-3">
                        Marca:<input type="text" name="marca" class="form-control" placeholder="Marca" value="${vehiculo.marca}"/>
                    </div>
                    <div class="col-lg-3">
                        Modelo:<input type="text" name="modelo" class="form-control" placeholder="Modelo" value="${vehiculo.modelo}"/>
                    </div>
                    <div class="col-lg-3">
                        Color:<input type="text" name="color" class="form-control" placeholder="Color" value="${vehiculo.color}"/>
                    </div>
                    <div class="col-lg-3">
                        Precio en millones:<input type="text" name="precio" class="form-control" placeholder="Precio" value="${vehiculo.precio}"/>
                    </div>
                </div>
                <table> 
                        <td colspan="2"><br>
                            <input class="btn btn-primary" type="submit" name="action" value="Agregar"/>
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
                </tr>
                </thead>
                <thead>
                <tr>
                    
                            <c:forEach items="${allVehiculos}" var="veh">
                                <td>${veh.matricula}</td>
                                <td>${veh.marca}</td>
                                <td>${veh.modelo}</td>
                                <td>${veh.color}</td>
                                <td>${veh.precio}</td>
                            </tr>
                </thead>
                        </c:forEach>
                    
                            <thead>
                            <tr>                
                                <td> ${message}</td>
                                <td>${message1}</td>
                                <td>${message2}</td>
                                <td>${message3}</td>
                                <td>${message4}</td>
                            </tr>
                            </thead>
                        
                    
                            <div class="alert alert-warning">
                                ${mensaje}
                            </div>
                    
                    
           </div>
        <script>
            window.onload=function(){
                if(window.location.href.endsWith("/vehiculo.jsp")){
                    window.location.href="/concesionario/VehiculoServlet";
                }
            }     
        </script>
    </body>
</html>