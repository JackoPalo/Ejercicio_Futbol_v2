import java.util.ArrayList;
import java.util.List;

public class JugadorDTOImp implements JugadorDTO{


    private String  Nombre;
    private int DNI;
    private List<contratoDTO> historial;

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    public JugadorDTOImp( int DNI,String nombre, List<contratoDTO> historial) {
        this.Nombre = nombre;
        this.DNI = DNI;
        this.historial = historial;
    }

    public JugadorDTOImp(String nombre, int DNI, List<equiposDTOImpo> clubes) {
        this.Nombre = nombre;
        this.DNI = DNI;
        this.historial = generarHistorial(DNI,clubes);
    }


    public String getNombre() {
        return this.Nombre;
    }


    public int getDNI() {
        return DNI;
    }


    public List<contratoDTO> getHistorial() {
        return historial;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setHistorial(List<contratoDTO> historial) {
        this.historial = historial;
    }

    public void imprimiHistorial(){
        for (int j = 0; this.getHistorial().size() > j; j++) {
            System.out.println("   " + this.getHistorial().get(j).getClub() + " desde " + this.getHistorial().get(j).getFecha_in() + " hasta " + this.getHistorial().get(j).getFecha_fin() + this.getHistorial().get(j).getPosicion());
        }
    }

    public List<contratoDTO> generarHistorial(int DNis,List<equiposDTOImpo> clubes){
        String[] Posiciones = {"Atacante","Defensor","Central"};
        java.util.Date fecha_ini;
        java.util.Date fecha_fin;
        List<contratoDTO> sHistorial = new ArrayList<>();
        for (equiposDTOImpo clube : clubes) {
            fecha_ini = new java.util.Date((int) (117 - Math.random() * 5), 1, 3);
            fecha_fin = new java.util.Date((int) (117 + Math.random() * 2), 1, 3);
            sHistorial.add(new contratoDTO(DNis, clube.getNombre(), Posiciones[(int) (Math.random() * 10) % 3], fecha_ini, fecha_fin,clube.getCUIT()));
        }

        return sHistorial;
    }



}
