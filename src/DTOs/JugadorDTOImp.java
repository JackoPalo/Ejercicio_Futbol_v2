package DTOs;

import java.util.List;

public class JugadorDTOImp implements JugadorDTO{
    private String  Nombre;
    private int DNI;
    private List<contratoDTOImp> historial;

    public String getNombre() {
        return this.Nombre;
    }
    public int getDNI() {
        return DNI;
    }
    public List<contratoDTOImp> getHistorial() {
        return historial;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setHistorial(List<contratoDTOImp> historial) {
        this.historial = historial;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }


}
