import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AFA {
    
    List<Equipos> equipos = new LinkedList();

    public AFA(String[] clubes) {
      for (int i = 0 ;clubes.length>i;i++){
          equipos.add(new Equipos(clubes[i]));

      }
    }


    public void MostrarLista (){
        for(int i=0;equipos.size() > i; i++){
                System.out.println(equipos.get(i).getNombre() + " Tiene " + equipos.get(i).getCantJugadores() + "");
        }

    }
    public void Ordenar(){

        Collections.sort(this.equipos, new Comparator<Equipos>() {
            public int compare(Equipos obj1, Equipos obj2) {
                return obj1.getNombre().compareToIgnoreCase(obj2.getNombre());
            }
        });
    }

    public void contarPosicion(String posicion){

        for(int i=0;equipos.size() > i; i++){
            int salida = 0;
            for (int j=0;equipos.get(i).Jugadores.size()>j; j++){
                if (equipos.get(i).Jugadores.get(j) instanceof Jugador) {
                    if (((Jugador) equipos.get(i).Jugadores.get(j)).getPosicion() == posicion) {
                        salida++;
                    }
                }
            }
            System.out.println(equipos.get(i).getNombre()+" Tiene "+ salida +" " +posicion+" es y un total de "+equipos.get(i).getCantJugadores()+"Jugadores");

        }

    }
    
}
