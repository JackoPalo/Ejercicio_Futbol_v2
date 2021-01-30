import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class Jugador implements jugadorRegistrable{
    private final String  Nombre;
    private final int DNI;
    private List<contrato> historial;

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    public Jugador(String nombre, int DNI, List<contrato> historial) {
        Nombre = nombre;
        this.DNI = DNI;
        this.historial = historial;
    }

    public String getNombre() {
        return this.Nombre;
    }


    public int getDNI() {
        return DNI;
    }

    public List<contrato> getHistorial() {
        return historial;
    }

    @Override
    public void insert() {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            st.execute("INSERT INTO `afa`.`jugador` (`DNI`, `nombre`) VALUES ('"+this.getDNI() +"', '"+this.getNombre()+"');");
            for(int j=0;this.getHistorial().size() >j; j++){
                fecha_in = new java.sql.Date(this.getHistorial().get(j).getFecha_in().getTime());
                fecha_fin = new java.sql.Date(this.getHistorial().get(j).getFecha_fin().getTime());
                st.execute("INSERT INTO `afa`.`contratos` (`DNI`, `fechaInicio`, `fechaFin`, `club`, `posicion`) VALUES ('"+this.getHistorial().get(j).getDNI()+"', '"+fecha_in+"', '"+fecha_fin+"', '"+this.getHistorial().get(j).getClub()+"', '"+this.getHistorial().get(j).getPosicion()+"');");

            }
        }catch (Exception e){
            System.out.println(" insert in Jugador ->   "+e.getMessage());
        } finally {
            try{
                if ( connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update() {

    }

    //@Override
    public void read() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs ;
            rs = st.executeQuery("SELECT * FROM afa.jugador");

            while(rs.next()){
                int aDNI= rs.getInt("DNI");
                String  aNombre=rs.getString("nombre");
                System.out.println("DNI: "+aDNI+" -  Nombre: "+aNombre);
            }

        }
        catch (Exception e) {
            System.out.println(" read in Jugador ->   "+e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public List<Jugador> readToLista() {
        Connection connection = null;
        List<Jugador> listaRetorno = new ArrayList<>();
        List<contrato> contratoList;
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs ;
            rs = st.executeQuery("SELECT * FROM afa.jugador");

            while(rs.next()){
                int aDNI= rs.getInt("DNI");
                String  aNombre=rs.getString("nombre");
                contratoList = contrato.readDNI(aDNI);
                listaRetorno.add(new Jugador(aNombre,aDNI,contratoList));

            }
        }
        catch (Exception e) {
            System.out.println(" readToLista in Jugador ->   "+e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(listaRetorno.equals(new ArrayList<Jugador>())){
            System.out.println("Lista de Jugadores Vacia");
        }
        return listaRetorno;
    }

    @Override
    public void delete() {

    }
}
