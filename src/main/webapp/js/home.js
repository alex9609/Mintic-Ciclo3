$(document).ready(function(){
    autenticarUsuario()

});

function autenticarUsuario(){

    let username = "alex"
    let contrasenia = "1234"
    let imagen = "img/autos/kia-picanto.png";
    resultado = false

    $.ajax({
        type: "GET",
        dataType: "html",
        url:"./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasenia: contrasenia
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if(parsedResult != false){
                let username = parsedResult['username'];
                //document.getElementById("auto1").innerHTML = "<img class=\"fotoauto\" src=\""+ imagen +"\">"
                console.log(username)
            }else{
                console.log("error")
            }
        }

    });


}