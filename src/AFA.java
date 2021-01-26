import java.util.*;

public class AFA {
    
    List<Equipos> equipos = new ArrayList();

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

    }
    
}
