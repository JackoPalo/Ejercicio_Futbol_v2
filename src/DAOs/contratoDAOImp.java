package DAOs;

import DTOs.*;
import Mainea.contrato;
import Servs.ServContratoImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class contratoDAOImp implements contratoDAO{

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    @Override
    public void insert(contratoDTOImp contrato) {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            fecha_in = new java.sql.Date(contrato.getFecha_in().getTime());
            fecha_fin = new java.sql.Date(contrato.getFecha_fin().getTime());
            st.execute("INSERT INTO `afa`.`contratos` (`DNI`, `fechaInicio`, `fechaFin`, `club`, `posicion`,`CUIT`) VALUES ('"+contrato.getDNI()+"', '"+fecha_in+"', '"+fecha_fin+"', '"+contrato.getClub()+"', '"+contrato.getPosicion()+"','"+contrato.getCUIT()+"');");


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
    public void update( contratoDTOImp contrato) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            fecha_in = new java.sql.Date(contrato.getFecha_in().getTime());
            fecha_fin = new java.sql.Date(contrato.getFecha_fin().getTime());
            st.execute(" UPDATE `afa`.`contratos` SET  `fechaInicio`='"+fecha_in+"', `fechaFin`='"+fecha_fin+"', `club`= '"+contrato.getClub()+"', `posicion`='"+contrato.getPosicion()+"' WHERE (`DNI` = '"+contrato.getDNI()+"') and (`CUIT` = '"+contrato.getCUIT()+"');");


        }catch (Exception e){
            System.out.println("update in Mainea.contrato->"+e.getMessage());
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
    public void read(contratoDTOImp contrato) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM afa.contratos WHERE (`DNI` = '"+contrato.getDNI()+"') and (`CUIT` = '"+contrato.getCUIT()+"');");
            rs.next();
            System.out.println(" DNI: "+ rs.getInt("DNI") + " Club: " +rs.getString("club") + " desde:" + rs.getDate("fechaInicio").toString()+ " hasta " + rs.getDate("fechaFin").toString() + " CUIT:"+rs.getInt("CUIT"));

        }
        catch (Exception e) {
            System.out.println("read in Mainea.contrato->"+e.getMessage());
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

    public List<contratoDTOImp> readDNI(int aDNI) {
        Connection connection = null;
        List<contrato> contratoList= new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs ;
            rs = st.executeQuery("SELECT * FROM afa.contratos");

            while(rs.next()) {
                if ((rs.getInt("DNI") == aDNI)) {
                    contratoList.add(new contrato(rs.getInt("DNI"), rs.getString("club"), rs.getString("posicion"), rs.getDate("fechaInicio"), rs.getDate("fechaFin"),rs.getInt("CUIT")));
                }
            }
            rs.beforeFirst();
        }
        catch (Exception e) {
            System.out.println("readDNI in Mainea.contrato->"+e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (contrato dto : contratoList) {
            System.out.println("   " + dto.getClub() + " desde " + dto.getFecha_in() + " hasta " + dto.getFecha_fin());
        }
        ServContratoImp Sc = new ServContratoImp();
        return Sc.contratoToContratoDTO(contratoList);
    }

    @Override
    public void delete(contratoDTOImp contrato) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in = new java.sql.Date(contrato.getFecha_in().getTime());
            st.execute("DELETE FROM `afa`.`contratos` WHERE (`DNI` = '"+contrato.getDNI()+"') and (`CUIT` = '"+contrato.getCUIT()+"') and (`fechaInicio` = '"+ fecha_in +"');");

        }catch (Exception e){
            System.out.println(" delete in contratos ->   "+e.getMessage());
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
