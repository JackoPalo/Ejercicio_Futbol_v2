package DTOs;

import DAOs.contratoDAO;
import DAOs.contratoDAOImp;

import java.util.Date;

public class contratoDTOImp implements contratoDTO {

    private int DNI,CUIT;
    private String posicion,club;
    private Date fecha_in,fecha_fin;

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

    public int getCUIT() { return this.CUIT; }


    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void setFecha_in(Date fecha_in) {
        this.fecha_in = fecha_in;
    }
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


}
