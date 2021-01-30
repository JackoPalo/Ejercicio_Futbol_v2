
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) {


        List<Equipos> clubes = Equipos.listaEquipos();
        for (Equipos clube : clubes) {
            clube.insert();
        }

        AFA Asociacion = new AFA(clubes);
        Asociacion.MostrarLista();
        Asociacion.Ordenar();
        //noinspection deprecation
        System.out.println(Asociacion.jugadoresPorFecha(new Date(118, Calendar.FEBRUARY,2),clubes));
        Asociacion.cargarAtabla();

    }

}
