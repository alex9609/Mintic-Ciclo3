package beans;


import java.sql.Date;

public class Alquiler {

    private String placa;
    private String username;
    private Date fecha;
    private boolean novedad;

    public Alquiler(String placa, String username, Date fecha, boolean novedad) {
        this.placa = placa;
        this.username = username;
        this.fecha = fecha;
        this.novedad= novedad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "placa='" + placa + '\'' +
                ", username='" + username + '\'' +
                ", fecha=" + fecha + '\'' +
                ", novedad=" + novedad +
                '}';
    }
}
