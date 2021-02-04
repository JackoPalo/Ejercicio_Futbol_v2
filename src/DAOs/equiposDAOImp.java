package DAOs;

import DTOs.*;
import Mainea.equipos;
import Servs.ServEquiposImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class equiposDAOImp implements equiposDAO {
    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    @Override
    public void insert(equiposDTOImp equipos) {

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
    public void update(equiposDTOImp equipos) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute(" UPDATE `afa`.`contratos` SET `CUIT`='"+equipos.getCUIT()+",  `nombre`= '"+equipos.getNombre() +", `division`='"+ equipos.getDivision()+"'', WHERE (`CUIT` = '"+equipos.getCUIT()+"');");

        }catch (Exception e){
            System.out.println("insert in Mainea.contrato->"+e.getMessage());
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
    public void read(equiposDTOImp equipos) {
        Connection connection = null;
        List<equiposDTOImp> equipoList= new ArrayList<>();
        ServEquiposImp ServE = new ServEquiposImp();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM afa.equipos");

            while(rs.next()) {
                equipoList.add(ServE.equiposModelToDTO(new equipos(rs.getInt("CUIT"), rs.getString("Nombre"), rs.getString("Division"))));
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

        for (equiposDTOImp equipo : equipoList) {
            System.out.println("   " + equipo.getCUIT() + " desde " + equipo.getNombre() + " hasta " + equipo.getDivision());
        }


    }

    @Override
    public void delete(equiposDTOImp equipos) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();

            st.execute("DELETE FROM `afa`.`Mainea.Equipos` WHERE (`CUIT` = '"+equipos.getCUIT()+"');");

        }catch (Exception e){
            System.out.println(" delete in Mainea.Equipos ->   "+e.getMessage());
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
