package test;
import  beans.Vehiculo;
import conection.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesBD {
    public static void main(String[] args){
        actualizarVehiculo("MNA012","Nissan");
        listarVehiculo();
    }

    public static void actualizarVehiculo(String placa, String marca){
        DBConnection con = new DBConnection();
        String sql = "UPDATE vehiculo SET  marca = ' " + marca + "' where placa = '" + placa +"'";

        try {
            Statement  st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("Actualiza correctamente");
        }catch(SQLException ex){
            System.out.println("No se pudo realizar la actualización :");
            System.out.println("Causa : " +ex.getCause());
            System.out.println("Mensaje : " +ex.getMessage());
        }finally {
            con.desconectar();
        }
    }

    public static void listarVehiculo(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM vehiculo ";

        try {
            Statement  st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){

                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int puertas = rs.getInt("puertas");
                String tipo = rs.getString("tipo");
                int anio = rs.getInt("anio");
                String motor = rs.getString("motor");
                String url_imagen = rs.getString("url_imagen");
                String novedad = rs.getString("novedad");
                int precio_dia = rs.getInt("precio_dia");

                Vehiculo vehiculo = new Vehiculo(
                        placa,
                        marca,
                        modelo,
                        puertas,
                        tipo,
                        anio,
                        motor,
                        url_imagen,
                        novedad,
                        precio_dia
                );

                System.out.println(vehiculo.toString());

            }
            st.executeQuery(sql);
        }catch(SQLException ex){
            System.out.println("No se pudo realizar la actualización :");
            System.out.println("Causa : " +ex.getCause());
            System.out.println("Mensaje : " +ex.getMessage());
        }finally {
            con.desconectar();
        }
    }
}
