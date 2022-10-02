package beans;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int puertas;
    private String tipo;
    private int anio;
    private String motor;
    private String url_imagen;
    private String novedad;
    private int precio_dia;

    public Vehiculo(String placa, String marca, String modelo, int puertas, String tipo, int anio, String motor, String url_imagen, String novedad, int precio_dia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.puertas = puertas;
        this.tipo = tipo;
        this.anio = anio;
        this.motor = motor;
        this.url_imagen = url_imagen;
        this.novedad = novedad;
        this.precio_dia = precio_dia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public int getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", puertas=" + puertas +
                ", tipo='" + tipo + '\'' +
                ", anio=" + anio +
                ", motor='" + motor + '\'' +
                ", url_imagen='" + url_imagen + '\'' +
                ", novedad='" + novedad + '\'' +
                ", precio_dia=" + precio_dia +
                '}';
    }
}
