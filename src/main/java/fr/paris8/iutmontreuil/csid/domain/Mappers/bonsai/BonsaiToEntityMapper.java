package fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;

public class BonsaiToEntityMapper {

    public static BonsaiEntity mapFromBonsai(Bonsai bonsai)
    {
        BonsaiEntity bonsaiEntity = new BonsaiEntity();

        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setStatus(bonsai.getStatus());
        bonsaiEntity.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiEntity.setAcquisition_date(bonsai.getAcquisition_date());

        return bonsaiEntity;
    }

}