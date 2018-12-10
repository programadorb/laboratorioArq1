package com.udea.controller;

import com.udea.dao.VehiculoDAO;
import com.udea.model.Vehiculo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;


//@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "VehiculoServlet", urlPatterns = {"/VehiculoServlet"})
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoDAO vehiculoDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        boolean buscarTodo=false;
        boolean controlMensaje = false;
        String mensaje = "";
        String codigo = request.getParameter("code"); //permite saber si se requiere texto !=1 o imagen ==1
        String vehmatricula = request.getParameter("matricula"); //Buscar el vehiculo para obtener su foto
        byte[] data = null;
        List<Vehiculo> listaVehiculos = vehiculoDAO.getAllVehiculos(); //Obtiene todos los vehiculos en la BD

        //Busca el vehículo requerido
        for (Vehiculo car : listaVehiculos) {
            String mat = car.getMatricula();
            if (mat.equalsIgnoreCase(vehmatricula)) {
                File file=new File(car.getFoto());
                data=java.nio.file.Files.readAllBytes(file.toPath());
            }
        }
        //Envía la imagen a la vista del vehículo
        if (codigo != null && "1".equalsIgnoreCase(codigo)) {
            response.setContentType("image/jpeg");
            response.getOutputStream().write(data);
            response.getOutputStream().close();
        } else {
            response.setContentType("text/html;charset=UTF-8");
        }
        //Se toman las acciones de los botones del formulario Vehículo    
        String action = request.getParameter("action");

        //se captura la matricula del formulario
        String matriculaStr = request.getParameter("matricula");
        String matricula = "";
        //Valida que el campo tenga algún dato
        if (matriculaStr != null && !matriculaStr.equals("")) {
            matricula = matriculaStr;
        }

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String color = request.getParameter("color");
        String preciostr = request.getParameter("precio");
        float precio = 0;
        //Valida que el campo precio tenga algun dato
        if (preciostr != null && !preciostr.equals("")) {
            precio = Float.parseFloat(preciostr);//convierte cadena de caracteres a float
        }
       
        //Obtiene la parte del archivo a cargar en la peticion (multipart)
        //valida que no esté vacio el archivo
            //Obtiene el input stream del archivo cargado y lo almacena como un arreglo de bytes
        
        //se invoca el constructor del POJO
       Vehiculo vehiculo = new Vehiculo();
       vehiculo.setMatricula(matricula);
       vehiculo.setMarca(marca);
       vehiculo.setModelo(modelo);
       vehiculo.setColor(color);
       vehiculo.setPrecio(precio);
       
       

        List<Vehiculo> v;
        //se invoca la acción de cada botón
        if ("Agregar".equalsIgnoreCase(action)) {
            vehiculoDAO.addVehiculo(vehiculo);
            mensaje= "El vehículo se ha agregado exitosamente";
        } else if ("Editar".equalsIgnoreCase(action)) {
            vehiculoDAO.editVehiculo(vehiculo);
            mensaje= "El vehículo se ha editado exitosamente";
        } else if ("Borrar".equalsIgnoreCase(action)) {
            vehiculoDAO.deleteVehiculo(matricula);
            mensaje= "El vehículo se ha borrado exitosamente";
        } else if ("Buscar".equalsIgnoreCase(action)) {
            
                vehiculo = vehiculoDAO.getVehiculo(matricula);
                request.setAttribute("message", vehiculo.getMatricula() + "  ");
                request.setAttribute("message1", vehiculo.getMarca() + "  ");
                request.setAttribute("message2", vehiculo.getModelo() + "  ");
                request.setAttribute("message3", vehiculo.getColor() + "  ");
                request.setAttribute("message4", vehiculo.getPrecio() + "  ");
         
                request.getRequestDispatcher("vehiculo.jsp").forward(request, response);
        }

        v = vehiculoDAO.getAllVehiculos();
        //se definen los atributos para la carga de datos
        request.setAttribute("vehiculo", vehiculo);// solo se llama un objeto
        //se llama todos los objetos retornados para la tabla HTML
        request.setAttribute("allVehiculos", vehiculoDAO.getAllVehiculos());
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("buscarTodo", buscarTodo);
        request.setAttribute("controlMensaje", controlMensaje);
        //redirecciona 
        request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
