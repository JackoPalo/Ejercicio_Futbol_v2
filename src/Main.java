public class Main {

    public static void main(String[] args) {

        String[] Posiciones = {"Atacante","Defensor","Central"};
        String[] nombres ={"pedro", "Juan","algo1","algo2","algo3","algo4","algo5", "algo6","algo7","algo8","algo9","algo0"};
        String[] clubes ={"Boca","River","Racing","independiente"};

        AFA Asociacion = new AFA(clubes);

        Asociacion.Ordenar();
        Asociacion.contarPosicion(Posiciones[1]);
        System.out.println("");
        Asociacion.MostrarLista();
    }

}
