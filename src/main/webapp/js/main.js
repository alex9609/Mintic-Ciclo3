var username = new URL(location.href).searchParams.get("username");


$(document).ready(function(){

    document.getElementById("titulo").setAttribute("href","home.html?username="+username);
    getUsuario().then(function(){
        $("#mi-perfil-btn").attr("href","profile.html?username="+username);
    })

    getVehiculos()
});

async function getUsuario(){

    await $.ajax({
        type: "GET",
        dataType:"html",
        url:"./ServletUsuarioPedir",
        data: $.param({
            username : username
        }),
        success: function (result){

            let parsedResult = JSON.parse(result);

            if(parsedResult != false){
                user = parsedResult
            }else{
                console.log("Error recuperando los datos del usuario")
            }
        }
    });
}


function getVehiculos(){

    $.ajax({
        type: "GET",
        dataType: "html",
        url:"./ServletVehiculoListar",
        data: $.param({  
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult != false){
                mostrarVehiculos(parsedResult);
            }else{
                console.log("Error trayendo la información")
            }
        }

    });
}

function mostrarVehiculos(vehiculos){

    let contenido = '';
    contador = 0;

    $.each(vehiculos, function(index,vehiculo){
        vehiculo = JSON.parse(vehiculo);
        
        if(contador == 0){
            contenido += "<div class='row'>"
        }
        //Codigo html para cada vehiculo
        contenido += "<div class='col'>"+
        "<div class='auto'>"+
            "<div class='row'>"+
                "<div class='col'>"+
                    "<h3>"+vehiculo.marca+ " "+vehiculo.modelo+"</h3>"+
                    "<h5>"+vehiculo.tipo+"</h5>"+
                "</div>"+
                "<div class='col'>"+
                    "<h4>Caracteristicas</h4>"+
                    "<ul>"+
                        "<li>"+
                            vehiculo.motor+
                        "</li>"+
                        "<li>"+
                            vehiculo.anio+
                        "</li>"+
                        "<li>"+
                            vehiculo.puertas+" puertas"+
                        "</li>"+
                    "</ul>"+
                "</div>"+
            "</div>"+
            "<div class='row'>"+
                "<div class='col d-flex justify-content-center '>"+
                    "<a class='reserva-auto' href='reservaAuto.html?username="+username+"&placa="+vehiculo.placa+"'>"+
                        "<img class='fotoauto' src='img/autos/"+ vehiculo.url_imagen +"'>"+
                    "</a>"+
                "</div>"+
                "<h5 class='precio'>Precio : $"+vehiculo.precio_dia+" cop/día</h5>"+
            "</div>"+
        "</div>"+
    "</div>";
        //
        contador += 1;
        if(contador == 3){
            contenido += "</div>"
            contenido += "<br><br>"
            contador = 0;
        }
    });
    contenido += "</div>"
    contenido += "<br><br>"

    $("#autos-body").html(contenido)
}

