package Servs;

import DAOs.contratoDAO;
import DAOs.contratoDAOImp;
import DTOs.*;

import Mainea.*;
import java.util.ArrayList;
import java.util.List;

public class ServContratoImp implements ServContrato{



    public void insert(contratoDTOImp contrat) {
        contratoDAO cDAO = new contratoDAOImp();
        cDAO.insert(contrat);
    }

    public void update(contratoDTOImp contrat) {
        contratoDAO cDAO = new contratoDAOImp();
        cDAO.update(contrat);
    }
    public void read(contratoDTOImp contrat) {
        contratoDAO cDAO = new contratoDAOImp();
        cDAO.read(contrat);
    }

    public void delete(contratoDTOImp contrat) {
        contratoDAO cDAO = new contratoDAOImp();
        cDAO.delete(contrat);
    }





    @Override
    public List<contrato> contrato_DTOToContrato(List<contratoDTOImp> contratos){
        List<contrato> cDAOList= new ArrayList<>();
        contrato cDTO;
        if (!contratos.isEmpty()) {
            for (int i = 0; contratos.size() > i; i++) {
                cDTO = new contrato(contratos.get(i).getDNI(),contratos.get(i).getClub(),contratos.get(i).getPosicion(),contratos.get(i).getFecha_in(),contratos.get(i).getFecha_fin(),contratos.get(i).getCUIT());
                cDAOList.add(cDTO);

            }
        }
        return cDAOList;
    }

    @Override
    public List<contratoDTOImp> generarHistorial(int DNis, List<equiposDTOImp> clubes){
        String[] Posiciones = {"Atacante","Defensor","Central"};
        java.util.Date fecha_ini;
        java.util.Date fecha_fin;
        contratoDTOImp cDTO = new contratoDTOImp();
        List<contratoDTOImp> sHistorial = new ArrayList<>();
        for (equiposDTOImp clube : clubes) {
            cDTO = new contratoDTOImp();
            fecha_ini = new java.util.Date((int) (117 - Math.random() * 5), 1, 3);
            fecha_fin = new java.util.Date((int) (117 + Math.random() * 2), 1, 3);
            cDTO.setClub(clube.getNombre());
            cDTO.setDNI(DNis);
            cDTO.setPosicion( Posiciones[(int) (Math.random() * 10) % 3]);
            cDTO.setFecha_in( fecha_ini);
            cDTO.setFecha_fin(fecha_fin);
            cDTO.setCUIT(clube.getCUIT());
            sHistorial.add(cDTO);
        }

        return sHistorial;
    }

    public List<contratoDTOImp> contratoToContratoDTO(List<contrato> historial) {
        List<contratoDTOImp> cDAOList= new ArrayList<>();
        contratoDTOImp cDTO = new contratoDTOImp();
        if (!historial.isEmpty()) {

            for (contrato h:historial) {
                cDTO = new contratoDTOImp();
                cDTO.setClub(h.getClub());
                cDTO.setDNI(h.getDNI());
                cDTO.setPosicion(h.getPosicion());
                cDTO.setFecha_in( h.getFecha_in());
                cDTO.setFecha_fin(h.getFecha_fin());
                cDTO.setCUIT(h.getCUIT());
                cDAOList.add(cDTO);
            }
        }

        return cDAOList;
    }
}
