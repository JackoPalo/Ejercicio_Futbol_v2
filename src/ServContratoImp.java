import java.util.ArrayList;
import java.util.List;

public class ServContratoImp implements ServContrato{

    @Override
    public List<contratoDTO> contrato_DTO(List<contrato> contratos){
        List<contratoDTO> cDAOList= new ArrayList<>();

        for (contrato cd :contratos){

            cDAOList.add(new contratoDTO(cd.getDNI(),cd.getClub(),cd.getPosicion(),cd.getFecha_in(),cd.getFecha_fin(),cd.getCUIT()));
        }

        return cDAOList;
    }
}
