package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    Connection connection;

    static String bd="rent_car";
    static String port="3306";
    static String login="root";
    private String password="z?K?7qmgPKni";

    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" +this.bd;
            connection = DriverManager.getConnection(url,this.login,this.password);
            System.out.println("Conexión establecida");
        }catch (Exception ex){
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println("Error de conexión");
        }
    }

    public Connection getConnection(){
        return  connection;
    }

    public void desconectar(){
        connection = null;
    }


}
