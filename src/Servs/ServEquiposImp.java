package Servs;

import DAOs.*;
import DTOs.JugadorDTOImp;
import DTOs.equiposDTOImp;
import Mainea.Jugador;
import Mainea.equipos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServEquiposImp implements ServEquipo{

    public equipos equiposDTOImpoToModel(equiposDTOImp eDTO){
        equipos emodel = new equipos(eDTO.getCUIT(),eDTO.getNombre(),eDTO.getDivision() );

        return emodel;
    }

    public equiposDTOImp equiposModelToDTO(equipos club){
        equiposDTOImp eDTO = new equiposDTOImp();
        eDTO.setCUIT(club.getCUIT());
        eDTO.setNombre(club.getNombre());
        eDTO.setDivision(club.getDivision());
        return eDTO;
    }

    public List<equiposDTOImp> listaEquipos() {
        List<equiposDTOImp> listaRetorno = new ArrayList<>();
        String[] equiposName = {"Boca", "River", "Racing", "independiente"};
        int[] equiposId = {8064, 5183, 5461, 1473};
        for (int i = 0; equiposName.length > i; i++) {
            listaRetorno.add( this.equiposModelToDTO(new equipos(equiposId[i], equiposName[i], "A")));
        }

        return listaRetorno;
    }

    public void insert(equiposDTOImp club) {
        equiposDAOImp cDAO = new  equiposDAOImp();
        cDAO.insert(club);
    }

    public void update(equiposDTOImp club) {
        equiposDAOImp cDAO = new  equiposDAOImp();
        cDAO.update(club);
    }

    public void read(equiposDTOImp club) {
        equiposDAOImp cDAO = new  equiposDAOImp();
        cDAO.read(club);
    }

    public void delete(equiposDTOImp club) {
        equiposDAOImp cDAO = new  equiposDAOImp();
        cDAO.delete(club);
    }


    public List<equiposDTOImp> clubes;
    public List<JugadorDTOImp> Jugadores = new ArrayList<>();
    public void jugadoresRandom(){
        ServJugadorImp ServJ = new ServJugadorImp();
        ServContratoImp ServC = new ServContratoImp();
        ServEquiposImp ServE = new ServEquiposImp();
        Integer[] DNis = { 1,2,3 ,4 ,5,6,7,8,9,10,11,12};
        String[] nombres ={"algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algoA10","algoA11","algoC"};
        this.clubes = ServE.listaEquipos();
        for(int i= 0; nombres.length > i;i++ ){
            Jugadores.add(ServJ.JUGADOR_DTO(new Jugador(DNis[i], nombres[i],ServC.generarHistorial(DNis[i],clubes))));

        }
    }
    public void MostrarLista (){
        for (JugadorDTOImp jugadore : Jugadores) {
            System.out.println(jugadore.getNombre() + " Jugo en " +
                    jugadore.getHistorial().size() + " clubes");
            for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                System.out.println("   " +jugadore.getHistorial().get(j).getClub()+ " desde " + jugadore.getHistorial().get(j).getFecha_in() + " hasta " + jugadore.getHistorial().get(j).getFecha_fin() + jugadore.getHistorial().get(j).getPosicion());

            }
        }

    }
    public void Ordenar(){
        this.Jugadores.sort((obj1, obj2) -> obj1.getNombre().compareToIgnoreCase(obj2.getNombre()));
    }
    public String jugadoresPorFecha(Date fecha, List<equiposDTOImp> clubes){
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

    public void cargarAtabla(){
        Connection connection = null;
        try {
            jugadorDAO jDAO = new JugadorDAOImp();
            equiposDAO eDAO = new equiposDAOImp();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement st = connection.createStatement();
            for (equiposDTOImp equipos: clubes){
                eDAO.insert(equipos);
            }
            for (int i =0 ;Jugadores.size()>i;i++) {
                jDAO.insert(Jugadores.get(i));

            }
        }catch(Exception e){
            System.out.println(" cargarTabla in Mainea.AFA ->  "+e.getMessage());
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
            jugadorDAO jDAO = new JugadorDAOImp();
            equiposDAO eDAO = new equiposDAOImp();
            contratoDAO cDAO = new contratoDAOImp();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement st = connection.createStatement();
            for (equiposDTOImp equipos: clubes){
                eDAO.delete(equipos);
            }
            for (JugadorDTOImp jugadore : Jugadores) {
                jDAO.delete(jugadore);
                for (int j = 0; jugadore.getHistorial().size() > j; j++) {
                    cDAO.delete(jugadore.getHistorial().get(j));
                }
            }
        }catch(Exception e){
            System.out.println(" cargarTabla in Mainea.AFA ->  "+e.getMessage());
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
