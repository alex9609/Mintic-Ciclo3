$(document).ready(function(){
    $("#info").submit(function(event){
        event.preventDefault();
        registrarUsuario();
    });
});

function registrarUsuario(){

    let username = $("#usuario").val()
    let contrasenia = $("#contrasenia").val();
    let confirmacion = $("#confirmacion").val();
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let email = $("#email").val();
    let saldo = $("#saldo").val();
    let metodo = $("#metodo").val();
    let suscripcion = $("#suscripcion").val();

    array = [
        {variable:'usuario',value:username},
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
            url:"./ServletUsuarioRegister",
            data: $.param({
                username: username,
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
                if(parsedResult != false){
                    $("#login-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "index.html";
                }else{
                    $("#login-error").removeClass("d-none");
                }
            }
    
        });
    }else{
        $("#create-error").removeClass("d-none");
        message = "Datos invalidos verifique por favor"
    }
    console.log(message)
    
}