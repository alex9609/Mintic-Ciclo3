package servlets;

import conection.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PruebaServlet", urlPatterns = ("/PruebaServlet"))
public class PruebaServlet extends  HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException{

        DBConnection dbConnection = new DBConnection();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Prueba Servlet en "+
                    request.getContextPath() + "</h1>");
            response.getWriter().append("El id que fue recibido es : " + id +
                    "y el nombre de la pelicula es :" + name);
            out.println("</center></body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
