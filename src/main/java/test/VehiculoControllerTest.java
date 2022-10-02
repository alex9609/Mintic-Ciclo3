package test;

import controller.VehiculoController;

public class VehiculoControllerTest {

    public static void main(String[] args) {

        VehiculoController vehiculoController = new VehiculoController();

        //testVehiculoControllerLista(vehiculoController);
        testVehiculoControllerPorPlaca(vehiculoController,"ASD345");
    }

    public static void testVehiculoControllerLista(VehiculoController vehiculoController){
        String valores = vehiculoController.listarVehiculos();
        System.out.println(valores);
    }

    public static void testVehiculoControllerPorPlaca(VehiculoController vehiculoController,String placa){
        String valores = vehiculoController.encontrarVehiculo_Placa(placa);
        System.out.println(valores);
    }
}
