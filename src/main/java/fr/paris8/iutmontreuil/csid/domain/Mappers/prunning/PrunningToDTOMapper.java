package fr.paris8.iutmontreuil.csid.domain.Mappers.prunning;

import fr.paris8.iutmontreuil.csid.domain.models.prunning.Prunning;
import fr.paris8.iutmontreuil.csid.exposition.DTO.PrunningDTO;

public class PrunningToDTOMapper {
    public static PrunningDTO mapFromPrunning(Prunning prunning){
        PrunningDTO prunningDTO = new PrunningDTO();
        prunningDTO.setId(prunning.getUuid());
        prunningDTO.setDate(prunning.getDatetime());
        return prunningDTO;
    }
}
