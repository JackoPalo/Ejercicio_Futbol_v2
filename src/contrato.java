import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class contrato implements contratoRegistrable{

    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="root";
    static final String pwd="";

    private int DNI;
    private String posicion,club;
    private Date fecha_in,fecha_fin;




    public contrato(int DNI, String club, String posicion, Date fecha_in, Date fecha_fin) {
        this.DNI = DNI;
        this.club = club;
        this.posicion = posicion;
        this.fecha_in = fecha_in;
        this.fecha_fin = fecha_fin;
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
            st.execute("INSERT INTO `afa`.`contratos` (`DNI`, `fechaInicio`, `fechaFin`, `club`, `posicion`) VALUES ('"+this.getDNI()+"', '"+fecha_in+"', '"+fecha_fin+"', '"+this.getClub()+"', '"+this.getPosicion()+"');");


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

    }

    @Override
    public void read() {
        Connection connection = null;
        List<contrato> contratoList= new ArrayList<>();
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs = st.getResultSet();
            rs = st.executeQuery("SELECT * FROM afa.contratos");

            while(rs.next()) {
                contratoList.add(new contrato(rs.getInt("DNI"), rs.getString("club"), rs.getString("posicion"), rs.getDate("fechaInicio"), rs.getDate("fechaFin")));
            }
            rs.beforeFirst();
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

        for(int j=0;contratoList.size()>j ;j++){
            System.out.println("   "+ contratoList.get(j).getClub()+" desde "+contratoList.get(j).getFecha_in()+" hasta "+contratoList.get(j).getFecha_fin() );
        }


    }
    public static List<contrato> readDNI(int aDNI) {
        Connection connection = null;
        List<contrato> contratoList= new ArrayList<>();
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            connection = DriverManager.getConnection(url,usr,pwd);
            Statement st = connection.createStatement();
            ResultSet rs = st.getResultSet();
            rs = st.executeQuery("SELECT * FROM afa.contratos");

            while(rs.next()) {
                if ((rs.getInt("DNI") == aDNI)) {
                    contratoList.add(new contrato(rs.getInt("DNI"), rs.getString("club"), rs.getString("posicion"), rs.getDate("fechaInicio"), rs.getDate("fechaFin")));
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

        for(int j=0;contratoList.size()>j ;j++){
            System.out.println("   "+ contratoList.get(j).getClub()+" desde "+contratoList.get(j).getFecha_in()+" hasta "+contratoList.get(j).getFecha_fin() );
        }

        return contratoList;
    }

    @Override
    public void delete() {

    }
}
