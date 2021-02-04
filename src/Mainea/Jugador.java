package Mainea;
import DTOs.*;
import Servs.*;

import java.util.List;

public class Jugador {

    private String  Nombre;
    private int DNI;
    private List<contrato> historial;

    public Jugador( int DNI,String nombre, List historial) {
        ServContratoImp Sc = new ServContratoImp();
        this.Nombre = nombre;
        this.DNI = DNI;
        if(historial.get(0) instanceof contratoDTOImp){
            this.historial = Sc.contrato_DTOToContrato(historial);
        }else if(historial.get(0) instanceof contrato) {
            this.historial = historial;
        }
    }
    public String getNombre() {
        return this.Nombre;
    }
    public int getDNI() {
        return DNI;
    }
    public List<contrato> getHistorial() {
        return historial;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setHistorial(List<contrato> historial) {
        this.historial = historial;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
}




