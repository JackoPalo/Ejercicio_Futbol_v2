import java.util.List;

public interface ServJugador {

    void imprimiHistorial(Jugador jugadore);
    List<contrato> generarHistorial(int DNis, List<Equipos> clubes);
    JugadorDTO JUGADOR_DTO(Jugador jugador);

}
