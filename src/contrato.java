import java.util.Date;

public class contrato {


    private int DNI;
    private String posicion,club;
    private Date fecha_in,fecha_fin;




    public contrato(int DNI, String club, String posicion, Date fecha_in, Date fecha_fin) {
        this.DNI = DNI;
        this.club = club;
        this.posicion = posicion;
        this.fecha_in = fecha_in;
        this.fecha_fin = fecha_fin;
    }

    public int getDNI() {
        return DNI;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getClub() {
        return club;
    }

    public Date getFecha_in() {
        return fecha_in;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }
}
