package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Usuario;
import com.google.gson.Gson;
import conection.DBConnection;

public class UsuarioController implements IUsuarioController {


    @Override
    public String login(String username, String contrasenia) {
        Gson gson = new Gson();

        DBConnection connection = new DBConnection();

        String sql = "SELECT * from usuario where username = '" + username +
                "' and contrasenia = '" + contrasenia + "'";

        try{
            Statement st = connection.getConnection().createStatement();
            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                double saldo = resultSet.getDouble("saldo");
                boolean premmium = resultSet.getBoolean("premmium");
                String metodo_pago = resultSet.getString("metodo_pago");

                Usuario usuario = new Usuario(
                        username,
                        contrasenia,
                        nombre,
                        apellido,
                        email,
                        metodo_pago,
                        saldo,
                        premmium
                );

                return gson.toJson(usuario);
            }
        }catch (SQLException ex){
            System.out.println("Error: ");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }finally {
            connection.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasenia, String nombre, String apellido, String email, float saldo, String metodo, int suscripcion) {
        Gson gson = new Gson();

        DBConnection connection = new DBConnection();

        String respuesta = "false";

        String sql = "INSERT INTO usuario (username,contrasenia,nombre,apellido,email,saldo,metodo_pago,premmium) VALUES"+
                "('"+username+"',"+
                "'"+contrasenia+"',"+
                "'"+nombre+"',"+
                "'"+apellido+"',"+
                "'"+email+"',"+
                "'"+saldo+"',"+
                "'"+metodo+"',"+
                "'"+suscripcion+"')";

        try{
            if(getUserByUsername(username).equals("false")){
                Statement st = connection.getConnection().createStatement();
                st.executeUpdate(sql);
                respuesta = "true";
            }
        }catch (SQLException ex){
            System.out.println("Error: ");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }finally {
            connection.desconectar();
        }
        return respuesta;
    }

    @Override
    public String getUserByUsername(String username) {
        Gson gson = new Gson();

        DBConnection connection = new DBConnection();

        String sql = "SELECT * from usuario where username = '" + username +"'";

        try{

            Statement st = connection.getConnection().createStatement();
            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String contrasenia = resultSet.getString("contrasenia");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                double saldo = resultSet.getDouble("saldo");
                boolean premmium = resultSet.getBoolean("premmium");
                String metodo_pago = resultSet.getString("metodo_pago");

                Usuario usuario = new Usuario(
                        username,
                        contrasenia,
                        nombre,
                        apellido,
                        email,
                        metodo_pago,
                        saldo,
                        premmium
                );

                return gson.toJson(usuario);
            }

        }catch (SQLException ex){
            System.out.println("Error: ");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }finally {
            connection.desconectar();
        }
        return "false";
    }
}
