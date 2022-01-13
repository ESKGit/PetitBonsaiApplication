package fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;

public class EntityToBonsaiMapper {

    public static Bonsai mapFromEntity(BonsaiEntity bonsaiEntity)
    {
        return new Bonsai(bonsaiEntity.getId(), bonsaiEntity.getName(), bonsaiEntity.getSpecies(), bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(), bonsaiEntity.getAcquisition_age());
    }
}
