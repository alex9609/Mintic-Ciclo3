
var placa = new URL(location.href).searchParams.get("placa");

$(document).ready(function(){

    getInformacionVehiculo();
});

function getInformacionVehiculo(){
    $.ajax({
        type: "GET",
        dataType: "html",
        url:"./ServletVehiculoPedir",
        data: $.param({
              placa: placa
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult != false){
                mostrarVehiculo(parsedResult);
                console.log(parsedResult)
            }else{
                console.log("Error trayendo la información")
            }
        }

    });
}

function mostrarVehiculo(vehiculo){
    document.getElementById("marca").innerHTML = vehiculo.marca + " " + vehiculo.modelo;
    document.getElementById("fotoauto").setAttribute("src","img/autos/"+vehiculo.url_imagen)
    document.getElementById("tipo").innerHTML = vehiculo.tipo;
    document.getElementById("cilindraje").innerHTML = vehiculo.motor;
    document.getElementById("anio").innerHTML = "Año : " + vehiculo.anio;
    document.getElementById("disponible").innerHTML = "Novedad : " + vehiculo.novedad;
    document.getElementById("puertas").innerHTML = "Puertas : " + vehiculo.puertas;

    document.getElementById("precio-dia").innerHTML = "Total a pagar: " + vehiculo.precio_dia;
}


