
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AFA {
    List<equiposDTOImpo> clubes;
    List<JugadorDTOImp> Jugadores = new ArrayList<>();
    ServJugadorImp ServJ = new ServJugadorImp();

    public AFA(){
        Integer[] DNis = { 1,2,3 ,4 ,5,6,7,8,9,10,11,12};
        String[] nombres ={"algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algoA10","algoA11","algoC"};
        this.clubes = equiposDTOImpo.listaEquipos();
        for(int i= 0; nombres.length > i;i++ ){
          //  Jugadores.add(new JugadorDTOImp(DNis[i],nombres[i],clubes));
        }
    }
    public void MostrarLista (){
        for (JugadorDTOImp jugadore : Jugadores) {
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
    public String jugadoresPorFecha(Date fecha,List<equiposDTOImpo> clubes){
        clubes.sort((s, t1) -> s.getNombre().compareToIgnoreCase(t1.getNombre()));
        String Salida = "";
        int[] contadorClubes = new int[clubes.size()];
        for (JugadorDTOImp jugadore : Jugadores) {
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
                Salida += clubes.get(i).getNombre() +" Tuvo "+contadorClubes[i]+" jugadores en la fecha: "+ fecha+"\n";
            }

        }
        if (Salida.equals("")){ Salida = "No hubo jugadores en esa fecha";}
        return Salida;
    }
    /*
    public void cargarAtabla(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement st = connection.createStatement();
            for (Equipos equipos: clubes){
                equipos.insert();
            }
            for (int i =0 ;Jugadores.size()>i;i++) {
                Jugadores.get(i).insert();
            }
        }catch(Exception e){
            System.out.println(" cargarTabla in AFA ->  "+e.getMessage());
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
    public void borrarTabla(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement st = connection.createStatement();
            for (Equipos equipos: clubes){
                equipos.delete();
            }
            for (Jugador jugadore : Jugadores) {
                jugadore.delete();
                for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                    jugadore.getHistorial().get(j).delete();
                }
            }
        }catch(Exception e){
            System.out.println(" cargarTabla in AFA ->  "+e.getMessage());
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
    */

}
