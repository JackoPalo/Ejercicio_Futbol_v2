package Servs;


import DAOs.JugadorDAOImp;
import DAOs.jugadorDAO;
import DTOs.*;

import Mainea.*;

public class ServJugadorImp implements ServJugador{
    @Override
    public void imprimiHistorial(Jugador jugadore) {
    }


    @Override
    public JugadorDTOImp JUGADOR_DTO(Jugador jugador) {
        ServContratoImp cDAOList = new ServContratoImp();
        JugadorDTOImp Jugadorsalida = new JugadorDTOImp();
        Jugadorsalida.setNombre(jugador.getNombre());
        Jugadorsalida.setHistorial(cDAOList.contratoToContratoDTO(jugador.getHistorial()));
        Jugadorsalida.setDNI(jugador.getDNI());
        return Jugadorsalida;
    }



    public void insert(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.insert(Juga);
    }

    public void update(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.update(Juga);
    }
    public void readHistorial(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.readHistorial(Juga);
    }

    public void read(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.read(Juga);
    }

    public void deleteHistorial(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.deleteHistorial(Juga);
    }

    public void delete(JugadorDTOImp Juga) {
        jugadorDAO cDAO = new JugadorDAOImp();
        cDAO.delete(Juga);
    }

    public void imprimiHistorial(JugadorDTOImp Juga){
        for (int j = 0; Juga.getHistorial().size() > j; j++) {
            System.out.println("   " + Juga.getHistorial().get(j).getClub() + " desde " + Juga.getHistorial().get(j).getFecha_in() + " hasta " + Juga.getHistorial().get(j).getFecha_fin() + Juga.getHistorial().get(j).getPosicion());
        }
    }

}
