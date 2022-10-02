package controller;

import beans.Vehiculo;

import java.util.List;

public interface IVehiculoController {

    String listarVehiculos();

    String encontrarVehiculo_Placa(String placa);
}
