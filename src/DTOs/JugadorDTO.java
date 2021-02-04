package DTOs;

import java.util.List;

public interface JugadorDTO {

    void setDNI(int DNI);
    void setHistorial(List<contratoDTOImp> historial);
    void setNombre(String nombre);
    List<contratoDTOImp> getHistorial();
    int getDNI();
    String getNombre();
}
