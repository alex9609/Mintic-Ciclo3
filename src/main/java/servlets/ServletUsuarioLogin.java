package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUsuarioLogin")
public class ServletUsuarioLogin extends HttpServlet{

    private static final long serialVersionIUD = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioController usuarioController = new UsuarioController();
        String username = req.getParameter("username");
        String contrasenia = req.getParameter("contrasenia");

        String result = usuarioController.login(username,contrasenia);
        System.out.println(result);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(result);
        printWriter.flush(); //Borra el dato o lo desecha
        printWriter.close(); //Cierra la memoria

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
