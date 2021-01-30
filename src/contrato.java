import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class contrato implements contratoRegistrable{

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    private int DNI,CUIT;
    private String posicion,club;
    private Date fecha_in,fecha_fin;





    public contrato(int DNI, String club, String posicion, Date fecha_in, Date fecha_fin,int CUIT) {
        this.DNI = DNI;
        this.club = club;
        this.posicion = posicion;
        this.fecha_in = fecha_in;
        this.fecha_fin = fecha_fin;
        this.CUIT=CUIT;
    }

    public int getDNI() {
        return DNI;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getClub() {
        return club;
    }

    public Date getFecha_in() {
        return fecha_in;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public int getCUIT() { return CUIT; }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void setFecha_in(Date fecha_in) {
        this.fecha_in = fecha_in;
    }
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public void insert() {

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            fecha_in = new java.sql.Date(this.getFecha_in().getTime());
            fecha_fin = new java.sql.Date(this.getFecha_fin().getTime());
            st.execute("INSERT INTO `afa`.`contratos` (`DNI`, `fechaInicio`, `fechaFin`, `club`, `posicion`,`CUIT`) VALUES ('"+this.getDNI()+"', '"+fecha_in+"', '"+fecha_fin+"', '"+this.getClub()+"', '"+this.getPosicion()+"','"+this.CUIT+"');");


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

    }

    @Override
    public void update() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            fecha_in = new java.sql.Date(this.getFecha_in().getTime());
            fecha_fin = new java.sql.Date(this.getFecha_fin().getTime());
            st.execute(" UPDATE `afa`.`contratos` SET  `fechaInicio`='"+fecha_in+"', `fechaFin`='"+fecha_fin+"', `club`= '"+this.getClub()+"', `posicion`='"+this.getPosicion()+"' WHERE (`DNI` = '"+this.getDNI()+"') and (`CUIT` = '"+this.getCUIT()+"');");


        }catch (Exception e){
            System.out.println("update in contrato->"+e.getMessage());
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
        List<contrato> contratoList= new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs;
            java.sql.Date fecha_in = new java.sql.Date(this.getFecha_in().getTime());
            rs = st.executeQuery("SELECT * FROM afa.contratos WHERE (`DNI` = '"+this.getDNI()+"') and (`CUIT` = '"+this.getCUIT()+"');");
            rs.next();
            System.out.println(" DNI: "+ rs.getInt("DNI") + " Club: " +rs.getString("club") + " desde:" + rs.getDate("fechaInicio").toString()+ " hasta " + rs.getDate("fechaFin").toString() + " CUIT:"+rs.getInt("CUIT"));

        }
        catch (Exception e) {
            System.out.println("read in contrato->"+e.getMessage());
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
    public static List<contrato> readDNI(int aDNI) {
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
            System.out.println("readDNI in contrato->"+e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (contrato contrato : contratoList) {
            System.out.println("   " + contrato.getClub() + " desde " + contrato.getFecha_in() + " hasta " + contrato.getFecha_fin());
        }

        return contratoList;
    }

    @Override
    public void delete() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
            Statement st = connection.createStatement();
            java.sql.Date fecha_in = new java.sql.Date(this.getFecha_in().getTime());
            st.execute("DELETE FROM `afa`.`contratos` WHERE (`DNI` = '"+this.getDNI()+"') and (`CUIT` = '"+this.getCUIT()+"') and (`fechaInicio` = '"+ fecha_in +"');");

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
