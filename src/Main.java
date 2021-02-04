import java.util.Date;


import Servs.*;


public class Main {

    public static void main(String[] args) {

        ServEquiposImp afa = new ServEquiposImp();
        ServJugadorImp ServJ = new ServJugadorImp();
        ServContratoImp ServC = new ServContratoImp();
        afa.borrarTabla();
        afa.cargarAtabla();
        afa.MostrarLista();
        System.out.println(afa.jugadoresPorFecha(new Date(116,1,3), afa.clubes));
        ServC.read(afa.Jugadores.get(5).getHistorial().get(0) );

    }

}
