var username = new URL(location.href).searchParams.get("username");


$(document).ready(function(){

    document.getElementById("titulo").setAttribute("href","home.html?username="+username);
    getUsuario(username);

    $("#update").submit(function(event){
        event.preventDefault();
        updateUser();
    });

    document.getElementById('eliminar').onclick = function() {
        deleteUser();
    }

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
                fillUser(user);
            }else{
                console.log("Error recuperando los datos del usuario")
            }
        }
    });
}

async function updateUser(){
    let username_new = $("#usuario").val()
    let contrasenia = $("#contrasenia").val();
    let confirmacion = $("#confirmacion").val();
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let email = $("#email").val();
    let saldo = $("#saldo").val();
    let metodo = $("#metodo").val();
    let suscripcion = $("#suscripcion").val();

    array = [
        {variable:'usuario',value:username_new},
        {variable:'contrasenia',value:contrasenia},
        {variable:'nombre',value:nombre},
        {variable:'apellido',value:apellido},
        {variable:'email',value:email},
        {variable:'saldo',value:saldo},
        {variable:'metodo',value:metodo},
        {variable:'suscripcion',value:suscripcion}]

    vacio = false;
    array.forEach(element => {
        if(element.value == "" || element.value == undefined){
            vacio = true;
        }
    });

    if(vacio == false && confirmacion == contrasenia){
        if(suscripcion == 'bronce'){
            suscripcion = 3
        }else if(suscripcion == 'plata'){
            suscripcion = 2
        }else{
            suscripcion = 1
        }

        //Comportamiento en ajax
        $.ajax({
            
            type: "GET",
            dataType: "html",
            url:"./ServletUsuarioUpdate",
            data: $.param({
                username_old: username,
                username_new: username_new,
                contrasenia: contrasenia,
                nombre:nombre,
                apellido:apellido,
                email:email,
                saldo:saldo,
                metodo:metodo,
                suscripcion:suscripcion
            }),
            success: function(result){
                let parsedResult = JSON.parse(result);
                console.log(parsedResult)
                if(parsedResult != false){
                    $("#create-error").addClass("d-none");
                    $("#success-info").removeClass("d-none");
                    setTimeout(function(){
                        document.location.href = "profile.html?username="+username_new;
                    },2000);
                }else{
                    document.getElementById("create-error").innerHTML = "Error al crear usuario";
                    $("#create-error").removeClass("d-none");
                    setTimeout(function(){
                        document.location.href = "profile.html?username="+username;
                    },2500);
                }
            }
    
        });
    }else{
        document.getElementById("create-error").innerHTML = "Datos invalidos, rellene todos los campos o asegurese que esten bien escritos";
        $("#create-error").removeClass("d-none");
    }
}

function fillUser(user){
    document.getElementById("usuario").setAttribute("value", user.username);
    document.getElementById("contrasenia").setAttribute("value", user.contrasenia);
    document.getElementById("confirmacion").setAttribute("value", user.contrasenia);
    document.getElementById("nombre").setAttribute("value", user.nombre);
    document.getElementById("apellido").setAttribute("value", user.apellido);
    document.getElementById("email").setAttribute("value", user.email);
    document.getElementById("saldo").setAttribute("value", user.saldo);
    document.getElementById("metodo").value = user.metodo_pago;

    if(user.suscripcion == 3){
        suscripcion = 'bronce'
    }else if(user.suscripcion == 2){
        suscripcion = 'plata'
    }else{
        suscripcion = 'oro'
    }
    document.getElementById("suscripcion").value = suscripcion;

}

async function deleteUser(){

    $.ajax({
            
        type: "GET",
        dataType: "html",
        url:"./ServletUsuarioDelete",
        data: $.param({
            username: username,
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            console.log(parsedResult)
            if(parsedResult != false){
                $("#success-delete").removeClass("d-none");
                setTimeout(function(){
                    document.location.href = "index.html";
                },2000);
            }else{
                document.getElementById("create-error").innerHTML = "Error al eliminar usuario";
                $("#create-error").removeClass("d-none");
                setTimeout(function(){
                    document.location.href = "profile.html?username="+username;
                },2500);
            }
        }

    });
    
}