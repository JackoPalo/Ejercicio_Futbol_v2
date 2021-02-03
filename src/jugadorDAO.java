import java.util.List;

public interface jugadorDAO {

    void insert(JugadorDTOImp jugador);
    void update(JugadorDTOImp jugador);
    void read(JugadorDTOImp jugador);
    void delete(JugadorDTOImp jugador);
    List<JugadorDTOImp> readToLista();

}
