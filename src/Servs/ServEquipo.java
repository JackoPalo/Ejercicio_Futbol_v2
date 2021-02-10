package Servs;

import DTOs.equiposDTOImp;
import Mainea.equipos;

public interface ServEquipo {

    equipos equiposDTOImpoToModel(equiposDTOImp eDTO);

    void insert(equiposDTOImp club);
    void read(equiposDTOImp club);
    void update(equiposDTOImp club);
    void delete(equiposDTOImp club);
    void jugadoresRandom();
    void Ordenar();
}
