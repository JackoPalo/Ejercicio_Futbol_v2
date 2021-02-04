package DTOs;


import java.util.Date;

public interface contratoDTO{

    int getDNI();
    String getPosicion();
    String getClub();
    Date getFecha_in();
    Date getFecha_fin();
    int getCUIT();
    void setDNI(int DNI);
    void setCUIT(int CUIT);
    void setClub(String club);
    void setPosicion(String posicion);
    void setFecha_in(Date fecha_in);
    void setFecha_fin(Date fecha_fin);



}
