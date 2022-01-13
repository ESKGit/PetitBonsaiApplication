package fr.paris8.iutmontreuil.csid.domain.Mappers.repotting;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.repotting.Repotting;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;

public class RepottingToEntityMapper {
    public static RepottingEntity mapFromRepotting(Repotting repotting){
        RepottingEntity repottingEntity = new RepottingEntity();
        repottingEntity.setId(repotting.getUuid());
        repottingEntity.setDatetime(repotting.getDatetime());
        repottingEntity.setBonsai(BonsaiToEntityMapper.mapFromBonsai(repotting.getBonsai()));
        return repottingEntity;
    }
}
