import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class Jugador implements jugadorRegistrable{

    private String  Nombre;
    private int DNI;
    private List<contrato> historial;

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    public Jugador(String nombre, int DNI, List<contrato> historial) {
        this.Nombre = nombre;
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

    public void setDNI(int aDNI) {

         this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setHistorial(List<contrato> historial) {
        this.historial = historial;
    }

    @Override
    public void insert() {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();

            st.execute("INSERT INTO `afa`.`jugador` (`DNI`, `nombre`) VALUES ('"+this.getDNI() +"', '"+this.getNombre()+"');");
            for(int j=0;this.getHistorial().size() >j; j++){
               this.getHistorial().get(j).insert();
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

        Connection connection = null;
        try {
            int Cid=0;
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            st.execute(" UPDATE `afa`.`jugador` SET  `nombre`= '"+this.getNombre() +"' WHERE (`DNI` = '"+this.getDNI()+"');");

        }catch (Exception e){
            System.out.println("update in Jugador->"+e.getMessage());
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

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            st.execute("DELETE FROM `afa`.`jugador` WHERE (`DNI` = '"+this.getDNI()+"');");

        }catch (Exception e){
            System.out.println(" delete in Jugador ->   "+e.getMessage());
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
}
