import java.util.ArrayList;
import java.util.List;

public class ServJugadorImp implements ServJugador{
    @Override
    public void imprimiHistorial(Jugador jugadore) {
    }

    @Override
    public List<contrato> generarHistorial(int DNis, List<Equipos> clubes) {
        return null;
    }



    @Override
    public JugadorDTO JUGADOR_DTO(Jugador jugador) { ;
        ServContratoImp cDAOList = new ServContratoImp();
        JugadorDTOImp Jugadorsalida =new JugadorDTOImp(jugador.getDNI(),jugador.getNombre(), cDAOList.contrato_DTO(jugador.getHistorial()));

        return Jugadorsalida;
    }
}
