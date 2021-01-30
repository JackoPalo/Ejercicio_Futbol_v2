public interface equioRegistrable {

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";


    void insert();
    void update();
    void read();
    void delete();

}
