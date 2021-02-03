import java.util.List;

public interface JugadorDTO {

    public void imprimiHistorial();
    public List<contratoDTO> generarHistorial(int DNis, List<equiposDTOImpo> clubes);

}
