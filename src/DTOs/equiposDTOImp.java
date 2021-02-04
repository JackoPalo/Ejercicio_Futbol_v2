package DTOs;

import DAOs.*;
import Mainea.Jugador;
import Servs.ServContratoImp;
import Servs.ServEquiposImp;
import Servs.ServJugadorImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class equiposDTOImp implements equiposDTO{
    private int CUIT;
    private String Nombre;
    private String Division;


    public int getCUIT() {
        return this.CUIT;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getDivision() {
        return this.Division;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDivision(String division) {
        Division = division;
    }





}
