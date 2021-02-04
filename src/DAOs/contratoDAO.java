package DAOs;

import DTOs.contratoDTOImp;

public interface contratoDAO {
    void insert(contratoDTOImp contrato);
    void update(contratoDTOImp contrato);
    void read(contratoDTOImp contrato);
    void delete(contratoDTOImp contrato);
}
