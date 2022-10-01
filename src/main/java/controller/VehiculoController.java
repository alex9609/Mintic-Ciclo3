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
                int anio = rs.getInt("anio");
                String motor = rs.getString("motor");
                String novedad = rs.getString("novedad");
                String url_imagen = rs.getString("url_imagen");

                Vehiculo vehiculo = new Vehiculo(
                        placa,
                        marca,
                        modelo,
                        anio,
                        motor,
                        novedad,
                        url_imagen
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
}
