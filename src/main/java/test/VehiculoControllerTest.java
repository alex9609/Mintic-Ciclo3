package test;

import controller.VehiculoController;

public class VehiculoControllerTest {

    public static void main(String[] args) {

        VehiculoController vehiculoController = new VehiculoController();

        testVehiculoControllerLista(vehiculoController);
    }

    public static void testVehiculoControllerLista(VehiculoController vehiculoController){
        String valores = vehiculoController.listarVehiculos();
        System.out.println(valores);
    }
}
