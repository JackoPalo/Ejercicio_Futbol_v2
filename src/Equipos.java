
import java.util.LinkedList;
import java.util.List;

public class Equipos  {


    private String Nombre;
    private int cantJugadores = 0;
    public List<persona> Jugadores = new LinkedList();


    public Equipos(String club ){
        this.Nombre = club;
        this.cantJugadores = 0;
        String[] nombres ={"algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algoA10","algoA11","algoC"};
        String[] Posiciones = {"Atacante","Defensor","Central"};
        for(int i= 0; nombres.length > i;i++ ){
            if ( i == 0 ) {
                Jugadores.add(new DT("Dt",club,"DT"));
            } else {
                Jugadores.add(new Jugador(club,Posiciones[i%3],nombres[i-1]));
                cantJugadores++;
            }
            System.out.print(Jugadores.get(i).Nombre + " " + club + " ");
            if (Jugadores.get(i) instanceof Jugador) {
                System.out.println(((Jugador) Jugadores.get(i)).getPosicion());
            }else if (Jugadores.get(i) instanceof DT){
                System.out.println(((DT) Jugadores.get(i)).getPosicion());
                }
        }

    }

    public int getCantJugadores() {

        return this.cantJugadores;

    }

    public String getNombre(){
        return this.Nombre;
    }


}
