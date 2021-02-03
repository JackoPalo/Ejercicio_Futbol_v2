import java.util.ArrayList;
import java.util.List;

public class equiposDTOImpo {
    private int CUIT;
    private String Nombre;
    private String Division;

    public equiposDTOImpo(int CUIT, String nombre, String division) {
        this.CUIT = CUIT;
        this.Nombre = nombre;
        this.Division = division;
    }

    public static List<equiposDTOImpo> listaEquipos() {
        List<equiposDTOImpo> listaRetorno = new ArrayList<>();
        String[] equiposName = {"Boca", "River", "Racing", "independiente"};
        int[] equiposId = {8064, 5183, 5461, 1473};
        for (int i = 0; equiposName.length > i; i++) {
            listaRetorno.add(new equiposDTOImpo(equiposId[i], equiposName[i], "A"));
        }

        return listaRetorno;
    }

    public int getCUIT() {
        return this.CUIT;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getDivision() {
        return this.Division;
    }

}
