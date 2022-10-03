var placa = new URL(location.href).searchParams.get("placa");
var username = new URL(location.href).searchParams.get("username");

$(document).ready(function(){
    document.getElementById("titulo").setAttribute("href","home.html?username="+username);
    $("#mi-perfil-btn").attr("href","profile.html?username="+username);
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
    document.getElementById("precio").innerHTML = "Precio día : " + vehiculo.precio_dia;
    document.getElementById("precio-dia").setAttribute("value", vehiculo.precio_dia);
    

}