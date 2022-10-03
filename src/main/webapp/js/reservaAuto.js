
$(document).ready(function(){

    const today = new Date();
    const yyyy = today.getFullYear();
    let mm = today.getMonth() + 1; // Months start at 0!
    let dd = today.getDate();
    
    if (dd < 10) dd = '0' + dd;
    if (mm < 10) mm = '0' + mm;
    

    hoy = yyyy + '-' + mm + '-' + dd
    maximo = (yyyy+1) + '-' + mm + '-' + dd

    document.getElementById("date-inicio").setAttribute("min", hoy);
    document.getElementById("date-inicio").setAttribute("max", maximo);
    document.getElementById("date-inicio").setAttribute("value", hoy);

    document.getElementById("date-fin").setAttribute("min", hoy);
    document.getElementById("date-fin").setAttribute("max", maximo);
    document.getElementById("date-fin").setAttribute("value", hoy);



    $("#alquilar-vehiculo").submit(function(event){
        event.preventDefault();
        alquilarVehiculo(true);
    });

    document.getElementById('calcular-tarifa').onclick = function() {
        alquilarVehiculo(false)
    }

});



function alquilarVehiculo(alquilar){

    let fecha_inicio = $("#date-inicio").val()
    let fecha_fin = $("#date-fin").val();


    fecha_invalida = false;

    if(fecha_inicio > fecha_fin){
        document.getElementById("create-error").innerHTML = "No se puede alquilar, fechas invalidas";
        $("#create-error").removeClass("d-none");
        $("#costo").addClass("d-none");
    }else{
        $("#create-error").addClass("d-none");

        var day_as_milliseconds = 86400000;
        var diff_in_millisenconds = new Date(fecha_fin) - new Date(fecha_inicio);
        var diff_in_days = (diff_in_millisenconds / day_as_milliseconds)+1;

        precio = diff_in_days * $("#precio-dia").val();

        //Diferencia de dias
        document.getElementById("costo").innerHTML = "Total a pagar: " + precio;
        $("#costo").removeClass("d-none");
        $("#alquilar").removeClass("d-none");

        if(alquilar){
            console.log("Entramos a ajax")
        }
    }


  
}