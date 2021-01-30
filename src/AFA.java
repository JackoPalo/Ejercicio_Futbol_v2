import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class AFA {
    
    List<Jugador> Jugadores = new ArrayList<>();

    public List<contrato> generarHistorial(int DNis,List<Equipos> clubes){
        String[] Posiciones = {"Atacante","Defensor","Central"};
        Date fecha_ini;
        Date fecha_fin;
        List<contrato> sHistorial = new ArrayList<>();
        for (Equipos clube : clubes) {
            fecha_ini = new Date((int) (117 - Math.random() * 5), 1, 3);
            fecha_fin = new Date((int) (117 + Math.random() * 2), 1, 3);
            sHistorial.add(new contrato(DNis, clube.getNombre(), Posiciones[(int) (Math.random() * 10) % 3], fecha_ini, fecha_fin));
        }

        return sHistorial;
    }

    public AFA(List<Equipos> clubes){

        Integer[] DNis = { 1,2,3 ,4 ,5,6,7,8,9,10,11,12};
        String[] nombres ={"algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algoA10","algoA11","algoC"};

        for(int i= 0; nombres.length > i;i++ ){

            List<contrato> historial = generarHistorial(DNis[i],clubes);
            Jugadores.add(new Jugador(nombres[i],DNis[i],historial));

        }

    }


    public void MostrarLista (){
        for (Jugador jugadore : Jugadores) {
            System.out.println(jugadore.getNombre() + " Jugo en " +
                    jugadore.getHistorial().size() + " clubes");
            for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                System.out.println("   " + jugadore.getHistorial().get(j).getClub() + " desde " + jugadore.getHistorial().get(j).getFecha_in() + " hasta " + jugadore.getHistorial().get(j).getFecha_fin() + jugadore.getHistorial().get(j).getPosicion());
            }
        }

    }
    public void Ordenar(){

        this.Jugadores.sort((obj1, obj2) -> obj1.getNombre().compareToIgnoreCase(obj2.getNombre()));
    }

    public String jugadoresPorFecha(Date fecha,List<Equipos> clubes){
        clubes.sort((s, t1) -> s.getNombre().compareToIgnoreCase(t1.getNombre()));
        String Salida = "";
        int[] contadorClubes = new int[clubes.size()];
        for (Jugador jugadore : Jugadores) {
            for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                if (fecha.after(jugadore.getHistorial().get(j).getFecha_in()) && fecha.before(jugadore.getHistorial().get(j).getFecha_fin())) {
                    //Salida+= Jugadores.get(i).getDNI()+" Jugo en  "+ Jugadores.get(i).getHistorial().get(j).getClub()+" desde "+ Jugadores.get(i).getHistorial().get(j).getFecha_in()+" hasta "+Jugadores.get(i).getHistorial().get(j).getFecha_fin()+"\n";
                    for (int k = 0; clubes.size() > k; k++) {
                        if (jugadore.getHistorial().get(j).getClub().equals(clubes.get(k).getNombre()))
                            contadorClubes[k]++;
                        //System.out.println(Jugadores.get(i).getHistorial().get(j).getClub());-----------Comprobando Resultados
                    }

                }
            }
        }
        if(!contadorClubes.equals( new int[clubes.size()])){
            for(int i= 0;clubes.size()>i ; i++){
                Salida += clubes.get(i) +" Tuvo "+contadorClubes[i]+" jugadores en la fecha: "+ fecha+"\n";
            }

        }
        if (Salida.equals("")){ Salida = "No hubo jugadores en esa fecha";}
        return Salida;
    }

    public void cargarAtabla(){
        Connection connection = null;
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement st = connection.createStatement();
            java.sql.Date fecha_in;
            java.sql.Date fecha_fin;
            for (Jugador jugadore : Jugadores) {
                st.execute("INSERT INTO `afa`.`jugador` (`DNI`, `nombre`) VALUES ('" + jugadore.getDNI() + "', '" + jugadore.getNombre() + "');");
                for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                    fecha_in = new java.sql.Date(jugadore.getHistorial().get(j).getFecha_in().getTime());
                    fecha_fin = new java.sql.Date(jugadore.getHistorial().get(j).getFecha_fin().getTime());
                    st.execute("INSERT INTO `afa`.`contratos` (`DNI`, `fechaInicio`, `fechaFin`, `club`, `posicion`) VALUES ('" + jugadore.getHistorial().get(j).getDNI() + "', '" + fecha_in + "', '" + fecha_fin + "', '" + jugadore.getHistorial().get(j).getClub() + "', '" + jugadore.getHistorial().get(j).getPosicion() + "');");

                }
            }


        }catch(Exception e){
            System.out.println(" estas testeando, borra la tabla pls   "+e.getMessage());
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
