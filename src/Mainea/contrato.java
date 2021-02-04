package Mainea;

import java.util.Date;

public class contrato {

    private int DNI,CUIT;
    private String posicion,club;
    private Date fecha_in,fecha_fin;

    public contrato(int DNI, String club, String posicion, Date fecha_in, Date fecha_fin,int CUIT) {
        this.DNI = DNI;
        this.club = club;
        this.posicion = posicion;
        this.fecha_in = fecha_in;
        this.fecha_fin = fecha_fin;
        this.CUIT=CUIT;
    }

    public int getDNI() {
        return this.DNI;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public String getClub() {
        return club;
    }

    public Date getFecha_in() {
        return this.fecha_in;
    }

    public Date getFecha_fin() {
        return this.fecha_fin;
    }

    public int getCUIT() { return CUIT; }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setFecha_in(Date fecha_in) {
        this.fecha_in = fecha_in;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
