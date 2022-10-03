package test;

import controller.UsuarioController;

public class UsuarioControllerTest {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();

        //System.out.println(usuarioController.login("alex","1234"));
        //System.out.println(usuarioController.login("camilo","12234"));

        testUsuarioControllerRegister(usuarioController);
        //testUsuarioControllerUpdate(usuarioController);
        //testUsuarioControllerDelete(usuarioController);
    }

    public static void testUsuarioControllerRegister(UsuarioController usuarioController){
        String rta = usuarioController.register("raul","1234","raul","rodri","aasda@homt.com",121212,"efectivo", 2);
        System.out.println(rta);
    }

    public static void testUsuarioControllerUpdate(UsuarioController usuarioController){
        String rta = usuarioController.update("raul","raulinho","1234","raul","rodri","aasda@homt.com",121212,"efectivo", 2);
        System.out.println(rta);
    }

    public static void testUsuarioControllerDelete(UsuarioController usuarioController){
        String rta = usuarioController.delete("raulinho");
        System.out.println(rta);
    }


}
