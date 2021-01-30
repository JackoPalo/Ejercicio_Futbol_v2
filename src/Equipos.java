import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Equipos implements equioRegistrable {
    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    private int CUIT;
    private String Nombre;
    private String Division;

    public Equipos(int CUIT, String nombre, String division) {
        this.CUIT = CUIT;
        this.Nombre = nombre;
        this.Division = division;
    }

    public static List<Equipos> listaEquipos(){
        List<Equipos> listaRetorno= new ArrayList<>();
        String[] equiposName ={"Boca", "River", "Racing", "independiente"};
        int[] equiposId = {8064,5183,5461,1473};
        for (int i=0;equiposName.length>i;i++){
            listaRetorno.add(new Equipos(equiposId[i],equiposName[i],"A" ));
        }

        return listaRetorno;
    }

    public int getCUIT() {
        return this.CUIT;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getDivision() {
        return this.Division;
    }

    @Override
    public void insert() {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute("INSERT INTO `afa`.`equipos` (`CUIT`, `nombre`, `division`) VALUES ('"+this.CUIT+"', '"+this.Nombre+"', '"+this.Division+"');");


        }catch (Exception e){
            System.out.println("insert in equipos->"+e.getMessage());
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
        /*
        Connection connection = null;
        try {
            int Cid=0;
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute(" UPDATE `afa`.`contratos` SET `CUIT`='"+this.getCUIT()+",  `nombre`= '"+this.getNombre() +", `division`='"+ this.Division+"'', WHERE (`CUIT` = '"+this.getCUIT()+"');");

        }catch (Exception e){
            System.out.println("insert in contrato->"+e.getMessage());
        } finally {
            try{
                if ( connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

         */
    }

    @Override
    public void read() {
        Connection connection = null;
        List<Equipos> equipoList= new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM afa.equipos");

            while(rs.next()) {
               equipoList.add(new Equipos(rs.getInt("CUIT"), rs.getString("Nombre"), rs.getString("Division")));
            }
            rs.beforeFirst();
        }
        catch (Exception e) {
            System.out.println("read in equipos->"+e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (Equipos equipos : equipoList) {
            System.out.println("   " + equipos.getCUIT() + " desde " + equipos.getNombre() + " hasta " + equipos.getDivision());
        }


    }

    @Override
    public void delete() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();

            st.execute("DELETE FROM `afa`.`Equipos` WHERE (`CUIT` = '"+this.getCUIT()+"');");

        }catch (Exception e){
            System.out.println(" delete in Equipos ->   "+e.getMessage());
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
