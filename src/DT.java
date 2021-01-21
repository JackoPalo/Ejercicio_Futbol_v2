public class DT extends persona{

    String club,posicion;

    public DT(String nombre,String club,String posicion) {
        super(nombre);
        this.club = club;
        this.posicion = posicion;

    }

    public String getPosicion() {
        return this.posicion;
    }


}
