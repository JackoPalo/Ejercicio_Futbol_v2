public interface equipoDAO {

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";


    void insert(equiposDTOImpo equipos);
    void update(equiposDTOImpo equipos);
    void read(equiposDTOImpo equipos);
    void delete(equiposDTOImpo equipos);

}
