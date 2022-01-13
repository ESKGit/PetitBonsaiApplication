package fr.paris8.iutmontreuil.csid.domain.Mappers.repotting;

import fr.paris8.iutmontreuil.csid.domain.models.repotting.Repotting;
import fr.paris8.iutmontreuil.csid.exposition.DTO.RepottingDTO;

public class RepottingToDTOMapper {
    public static RepottingDTO mapFromRepotting(Repotting repotting){
        RepottingDTO repottingDTO = new RepottingDTO();
        repottingDTO.setId(repotting.getUuid());
        repottingDTO.setDate(repotting.getDatetime());
        return repottingDTO;
    }
}
