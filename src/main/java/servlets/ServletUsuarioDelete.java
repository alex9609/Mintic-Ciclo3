package servlets;

import controller.UsuarioController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletUsuarioDelete")
public class ServletUsuarioDelete extends HttpServlet{

    private static final long serialVersionIUD = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioController usuarioController = new UsuarioController();
        String username = req.getParameter("username");;

        String result = usuarioController.delete(username);

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
