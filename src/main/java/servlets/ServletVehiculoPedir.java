package servlets;

import controller.VehiculoController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ServletVehiculoPedir")
public class ServletVehiculoPedir extends HttpServlet{

    private static final long serialVersionIUD = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VehiculoController vehiculo = new VehiculoController();
        String placa = req.getParameter("placa");

        String vehiculos = vehiculo.encontrarVehiculo_Placa(placa);

        System.out.println("Listado de vehiculos");
        System.out.println(vehiculos);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(vehiculos);
        printWriter.flush(); //Borra el dato o lo desecha
        printWriter.close(); //Cierra la memoria

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
