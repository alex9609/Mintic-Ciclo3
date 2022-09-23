package controller;
import java.util.Map;

public interface IUsuarioController {
    String login(String username,String contrasenia);

    String register(String username,String contrasenia,String nombre,
                    String apellido, String email, float saldo,String meotdo, int suscripcion);

    String getUserByUsername(String username);
}
