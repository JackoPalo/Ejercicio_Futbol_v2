package DAOs;

import DTOs.*;
import Mainea.Jugador;
import Servs.ServJugadorImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOImp implements jugadorDAO{

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    @Override
    public void insert(JugadorDTOImp jugador) {

        Connection connection = null;
        contratoDAOImp contratoDAO=new contratoDAOImp();
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();

            st.execute("INSERT INTO `afa`.`jugador` (`DNI`, `nombre`) VALUES ('"+jugador.getDNI() +"', '"+jugador.getNombre()+"');");
            for(int j=0;jugador.getHistorial().size() >j; j++){
                contratoDAO.insert(jugador.getHistorial().get(j));
            }
        }catch (Exception e){
            System.out.println(" insert in Mainea.Jugador ->   "+e.getMessage());
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
    public void update(JugadorDTOImp jugador) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute(" UPDATE `afa`.`jugador` SET  `nombre`= '"+jugador.getNombre() +"' WHERE (`DNI` = '"+jugador.getDNI()+"');");

        }catch (Exception e){
            System.out.println("update in Mainea.Jugador->"+e.getMessage());
        } finally {
            try{
                if ( connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }//solo update nombre

    @Override
    public void read(JugadorDTOImp jugador) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs ;
            rs = st.executeQuery("SELECT * FROM `afa`.`jugador` WHERE (`DNI` ='"+jugador.getDNI()+"')");
            rs.next();
            int aDNI= rs.getInt("DNI");
            String  aNombre=rs.getString("nombre");
            System.out.println("DNI: "+aDNI+" -  Nombre: "+aNombre);
        }
        catch (Exception e) {
            System.out.println(" read in Mainea.Jugador ->   "+e.getMessage());
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

    public void deleteHistorial(JugadorDTOImp jugador) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute("DELETE FROM `afa`.`contratos` WHERE (`DNI` = '"+jugador.getDNI()+"');");

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

    @Override
    public void delete(JugadorDTOImp jugador) {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            st.execute("DELETE FROM `afa`.`jugador` WHERE (`DNI` = '"+jugador.getDNI()+"');");
            this.deleteHistorial(jugador);// Borra historial de Mainea.Jugador

        }catch (Exception e){
            System.out.println(" delete in Mainea.Jugador ->   "+e.getMessage());
        } finally {
            try{
                if ( connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }//Eliminia historial de Mainea.Jugador


    public List<JugadorDTOImp> readToLista() {
        Connection connection = null;
        List<JugadorDTOImp> listaRetorno = new ArrayList<>();
        List<contratoDTOImp> contratoList;
        contratoDAOImp cDAO = new contratoDAOImp();
        ServJugadorImp ServJ = new ServJugadorImp();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs ;
            rs = st.executeQuery("SELECT * FROM afa.jugador");

            while(rs.next()){
                int aDNI= rs.getInt("DNI");
                String  aNombre=rs.getString("nombre");
                contratoList = cDAO.readDNI(aDNI);
                listaRetorno.add(ServJ.JUGADOR_DTO(new Jugador(aDNI,aNombre,contratoList)));

            }
        }
        catch (Exception e) {
            System.out.println(" readToLista in Mainea.Jugador ->   "+e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(listaRetorno.equals(new ArrayList<JugadorDTOImp>())){
            System.out.println("Lista de Jugadores Vacia");
        }
        return listaRetorno;
    }

    public void readHistorial(JugadorDTOImp jugador) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM afa.contratos WHERE (DNI = '"+ jugador.getDNI()+"')");

            while(rs.next()) {
                System.out.println(" DNI: "+ rs.getInt("DNI") + " Club: " +rs.getString("club") + " desde:" + rs.getDate("fechaInicio").toString()+ " hasta " + rs.getDate("fechaFin").toString() + " CUIT:"+rs.getInt("CUIT"));

            }
        }
        catch (Exception e) {
            System.out.println("readHistorial in Mainea.Jugador->"+e.getMessage());
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
}
