package controller;

import beans.Vehiculo;
import com.google.gson.Gson;
import conection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController implements IVehiculoController {


    @Override
    public String listarVehiculos() {
        Gson gson = new Gson();

        DBConnection connection = new DBConnection();
        String sql = "Select * from vehiculo";

        List<String> listaVehiculos = new ArrayList<String>();

        try{
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){

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

                listaVehiculos.add(gson.toJson(vehiculo));

            }
        }catch (SQLException ex){
            System.out.println("Error: ");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }finally {
            connection.desconectar();
        }
        return gson.toJson(listaVehiculos);

    }

    @Override
    public String encontrarVehiculo_Placa(String placa) {
        Gson gson = new Gson();

        DBConnection connection = new DBConnection();
        String sql = "Select * from vehiculo where placa =  '" + placa +"'";


        try{
            Statement st = connection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){

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

                return gson.toJson(vehiculo);
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
