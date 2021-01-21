public class Jugador extends persona {
    String  Telefono,emails,club,fechas_entre_las_cuales_jugo,Fecha_nacimiento,fecha_debut,partidosJugados,peso,altura, posicion;
    int goles;

    public Jugador(String club, String posicion, String Nombre) {
        super(Nombre);
        this.club = club;
        this.posicion = posicion;
    }

    public String getPosicion() {
        return this.posicion;
    }
}
