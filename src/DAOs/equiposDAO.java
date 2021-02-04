package DAOs;

import DTOs.equiposDTOImp;

public interface equiposDAO {

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";


    void insert(equiposDTOImp equipos);
    void update(equiposDTOImp equipos);
    void read(equiposDTOImp equipos);
    void delete(equiposDTOImp equipos);

}
