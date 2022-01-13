package fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.exposition.DTO.BonsaiDTO;

public class BonsaiToDTOMapper {

    public static BonsaiDTO mapFromBonsai(Bonsai bonsai)
    {
        BonsaiDTO bonsaiDTO = new BonsaiDTO();
        bonsaiDTO.setId(bonsai.getId());
        bonsaiDTO.setName(bonsai.getName());
        bonsaiDTO.setSpecies(bonsai.getSpecies());
        bonsaiDTO.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiDTO.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiDTO.setStatus(bonsai.getStatus());

        return bonsaiDTO;
    }

    public static Bonsai mapfromDTO(BonsaiDTO bonsaiDTO){
        return new Bonsai(bonsaiDTO.getId(), bonsaiDTO.getName(), bonsaiDTO.getSpecies(),bonsaiDTO.getStatus(),bonsaiDTO.getAcquisition_date(),  bonsaiDTO.getAcquisition_age());
    }
}
