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
        <title>venta</title>
        <nav role="navigation" class="navbar">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="cliente.jsp">Clientes</a></li>
                <li ><a href="vehiculo.jsp">Vehiculos</a></li>
                <li class="active"><a href="venta.jsp">Ventas</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>VENTA</h1>

            <form action="./VentasServlet" method="POST">
                <div class="col-lg-12">
                    <div class="col-lg-3">
                        Código Venta:<input type="text" name="codigo" class="form-control" placeholder="Código" value="${venta.codigo}"/>
                    </div>
                    <div class="col-lg-3">
                        Cliente:<input type="text" name="cliente" class="form-control" placeholder="Cliente" value="${venta.cliente}"/>
                    </div>

                    <div class="col-lg-3">
                        Vehículo:<input type="text" name="vehiculo" class="form-control" placeholder="Vehículo" value="${venta.vehiculo}"/>
                    </div>

                    <div class="col-lg-3">
                        Valor Total:<input type="text" name="valor_total" class="form-control" placeholder="Valor" value="${venta.valor_total}"/>
                    </div>
                </div>
                <table>                   
                    <tr>
                    <td  colspan="2"><br>
                            <input class="btn btn-primary" type="submit" name="action" value="Agregar"/>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <table class="table table-inverse">
                <thead>
                <tr class="info">
                    <th>Código</th>
                    <th>Cliente</th>
                    <th>Vehículo</th>
                    <th>Valor</th>
                </tr>
                </thead>
                <thead>
                <tr>
                            <c:forEach items="${allVentas}" var="venta">
                                <td>${venta.codigo}</td>
                                <td>${venta.cliente}</td>
                                <td>${venta.vehiculo}</td>
                                <td>${venta.valor}</td>
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
                            <div class="alert alert-warning">
                                ${mensaje}
                            </div>
        </div>
        <script>
            window.onload=function(){
                if(window.location.href.endsWith("/venta.jsp")){
                    window.location.href="/concesionario/VentasServlet";
                }
            }     
        </script>
    </body>