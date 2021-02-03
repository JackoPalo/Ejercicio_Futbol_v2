import java.util.List;

public interface contratoDAO {
    void insert(contratoDTO contrato);
    void update(contratoDTO contrato);
    void read(contratoDTO contrato);
    void delete(contratoDTO contrato);
}
