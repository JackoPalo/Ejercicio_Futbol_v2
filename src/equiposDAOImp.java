import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class equiposDAOImp implements equipoDAO{
    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    @Override
    public void insert(equiposDTOImpo equipos) {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute("INSERT INTO `afa`.`equipos` (`CUIT`, `nombre`, `division`) VALUES ('"+equipos.getCUIT()+"', '"+equipos.getNombre()+"', '"+equipos.getDivision()+"');");


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
    public void update(equiposDTOImpo equipos) {
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
    public void read(equiposDTOImpo equipos) {
        Connection connection = null;
        List<equiposDTOImpo> equipoList= new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM afa.equipos");

            while(rs.next()) {
                equipoList.add(new equiposDTOImpo(rs.getInt("CUIT"), rs.getString("Nombre"), rs.getString("Division")));
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

        for (equiposDTOImpo equipo : equipoList) {
            System.out.println("   " + equipo.getCUIT() + " desde " + equipo.getNombre() + " hasta " + equipo.getDivision());
        }


    }

    @Override
    public void delete(equiposDTOImpo equipos) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();

            st.execute("DELETE FROM `afa`.`Equipos` WHERE (`CUIT` = '"+equipos.getCUIT()+"');");

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
