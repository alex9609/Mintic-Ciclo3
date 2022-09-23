package test;

import controller.UsuarioController;

public class UsuarioControllerTest {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();

        //System.out.println(usuarioController.login("alex","1234"));
        //System.out.println(usuarioController.login("camilo","12234"));

        testUsuarioControllerRegister(usuarioController);
    }

    public static void testUsuarioControllerRegister(UsuarioController usuarioController){
        String rta = usuarioController.register("raul","1234","raul","rodri","aasda@homt.com",121212,"efectivo", 2);
        System.out.println(rta);
    }


}
