<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet"
              href="https://bootswatch.com/darkly/bootstrap.min.css">
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Información del Cliente</title>
         <nav role="navigation" class="navbar">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="cliente.jsp">Clientes</a></li>
                <li><a href="vehiculo.jsp">Vehículos</a></li>
                <li><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>Cliente</h1>

            <form action="./ClienteServlet" method="POST">
                <div class="col-lg-12">
                    <div class="col-lg-3">
                        Cédula : <input type="text" name="cedula" class="form-control" placeholder="Cédula" value="${cliente.cedula}"/>
                    </div>
                    <div class="col-lg-3">
                        Nombre: <input type="text" name="Apellido" class="form-control" placeholder="Nombre" value="${cliente.apellido}"/>
                    </div>

                    <div class="col-lg-3">
                        Dirección: <input type="text" name="Direccion" class="form-control" placeholder="Dirección" value="${cliente.direccion}"/>
                    </div>

                    <div class="col-lg-3">
                        Teléfono: <input type="text" name="Telefono" class="form-control" placeholder="Teléfono" value="${cliente.telefono}"/>
                    </div>
                </div>
                <table>
                    <tr>
                        <td  colspan="2"><br>
                            <input class="btn" type="submit" name="action" value="Agregar"/>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <table class="table">
                <thead>
                    <tr class="">
                        <th>Cédula</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                    </tr>
                </thead>
                <thead>
                <tr>
                    
                    <c:forEach items="${allClientes}" var="cliente">
                            
                        <td>${cliente.cedula}</td>
                        <td>${cliente.apellido}</td>
                        <td>${cliente.direccion}</td>
                        <td>${cliente.telefono}</td>
                    </tr>
                </thead>
                        </c:forEach>
                    
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
                
                            <div class="alert alert-warning">
                                ${mensaje}
                            </div>
                        
                
        </div>
        <script>
            window.onload=function(){
                if(window.location.href.endsWith("concesionario/") || window.location.href.endsWith("cliente.jsp")){
                    window.location.href="/concesionario/ClienteServlet";
                }
            }     
        </script>
    </body>
</html>