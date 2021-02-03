
import java.util.List;

public class Jugador {

    private String  Nombre;
    private int DNI;
    private List<contrato> historial;

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    public Jugador( int DNI,String nombre, List<contrato> historial) {
        this.Nombre = nombre;
        this.DNI = DNI;
        this.historial = historial;
    }


    public String getNombre() {
        return this.Nombre;
    }


    public int getDNI() {
        return DNI;
    }


    public List<contrato> getHistorial() {
        return historial;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setHistorial(List<contrato> historial) {
        this.historial = historial;
    }


}




