package beans;

public class Usuario {

    private String username;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String email;
    private String metodo_pago;
    private double saldo;
    private boolean premmium;

    public Usuario(String username, String contrasenia, String nombre, String apellido, String email, String metodo_pago, double saldo, boolean premmium) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.metodo_pago = metodo_pago;
        this.saldo = saldo;
        this.premmium = premmium;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isPremmium() {
        return premmium;
    }

    public void setPremmium(boolean premmium) {
        this.premmium = premmium;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", metodo pago='" + metodo_pago + '\'' +
                ", saldo=" + saldo +
                ", premmium=" + premmium +
                '}';
    }
}
