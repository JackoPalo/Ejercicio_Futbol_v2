package Mainea;

import java.util.ArrayList;
import java.util.List;

public class equipos {
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String usr = "root";
    static final String pwd = "";

    private int CUIT;
    private String Nombre;
    private String Division;

    public equipos(int CUIT, String nombre, String division) {
        this.CUIT = CUIT;
        this.Nombre = nombre;
        this.Division = division;
    }

    public static List<equipos> listaEquipos() {
        List<equipos> listaRetorno = new ArrayList<>();
        String[] equiposName = {"Boca", "River", "Racing", "independiente"};
        int[] equiposId = {8064, 5183, 5461, 1473};
        for (int i = 0; equiposName.length > i; i++) {
            listaRetorno.add(new equipos(equiposId[i], equiposName[i], "A"));
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