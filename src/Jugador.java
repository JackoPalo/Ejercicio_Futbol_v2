import java.util.List;

public class Jugador {
    private String  Nombre,Telefono,emails,club;
    private int DNI;
    private List<contrato> historial;

    public Jugador(String nombre, int DNI, List<contrato> historial) {
        Nombre = nombre;
        this.DNI = DNI;
        this.historial = historial;
    }

    public String getNombre() {
        return this.Nombre;
    }
    public String getClub() {
        return club;
    }

    public int getDNI() {
        return DNI;
    }

    public List<contrato> getHistorial() {
        return historial;
    }
}
