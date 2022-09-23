package test;

import controller.UsuarioController;

public class UsuarioControllerTest {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();

        System.out.println(usuarioController.login("alex","1234"));
        System.out.println(usuarioController.login("camilo","12234"));
    }
}
