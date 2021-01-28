import java.sql.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        String[] Posiciones = {"Atacante","Defensor","Central"};
        String[] nombres ={"pedro", "Juan","algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algo0"};
        List<String> clubes = Arrays.asList(new String[]{"Boca", "River", "Racing", "independiente"});


        AFA Asociacion = new AFA(clubes);
        Asociacion.MostrarLista();
        Asociacion.Ordenar();
        System.out.println("");
        System.out.println(Asociacion.jugadoresPorFecha(new Date(118,1,2),clubes));
        Asociacion.cargarAtabla();
    }

}
