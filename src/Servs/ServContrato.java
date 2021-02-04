package Servs;


import DTOs.*;

import Mainea.*;
import java.util.List;

public interface ServContrato {

    public List<contrato> contrato_DTOToContrato(List<contratoDTOImp> contratos);

    List<contratoDTOImp> generarHistorial(int DNis, List<equiposDTOImp> clubes);
}
