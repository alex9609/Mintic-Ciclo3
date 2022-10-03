package servlets;

import controller.UsuarioController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletUsuarioUpdate")
public class ServletUsuarioUpdate extends HttpServlet{

    private static final long serialVersionIUD = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioController usuarioController = new UsuarioController();
        String username_old = req.getParameter("username_old");
        String username_new = req.getParameter("username_new");
        String contrasenia = req.getParameter("contrasenia");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        int saldo = Integer.parseInt(req.getParameter("saldo"));
        String metodo = req.getParameter("metodo");
        int suscripcion = Integer.parseInt(req.getParameter("suscripcion"));

        String result = usuarioController.update(username_old,
                username_new,
                contrasenia,
                nombre,
                apellido,
                email,
                saldo,
                metodo,
                suscripcion);

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
