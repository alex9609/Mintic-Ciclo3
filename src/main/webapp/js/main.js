

var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function(){

/**$(function (){
        $('[data-toggle="tooltip"]').tooltip();
    });
**/
    getUsuario().then(function(){

        $("#mi-perfil-btn").attr("href","profile.html?username="+username);

        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

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
                    "<h5>Lujo</h5>"+
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
                            "4 asientos"+
                        "</li>"+
                    "</ul>"+
                "</div>"+
            "</div>"+
            "<div class='row'>"+
                "<div class='col d-flex justify-content-center '>"+
                    "<a class='reserva-auto' href='index.html'>"+
                        "<img class='fotoauto' src='img/autos/"+ vehiculo.url_imagen +"'>"+
                    "</a>"+
                "</div>"+
            "</div>"+
            //boton
            /*
            "<div class='row'>"+
                "<div class='col d-flex justify-content-center mt-4 mb-3'>"+
                "<button type='button' class='btn btn-primary'>Reservar</button>"+
                "</div>"+
            "</div>"+
            */
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

