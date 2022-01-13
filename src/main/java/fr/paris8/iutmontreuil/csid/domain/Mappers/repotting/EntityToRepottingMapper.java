package fr.paris8.iutmontreuil.csid.domain.Mappers.repotting;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.repotting.Repotting;
import fr.paris8.iutmontreuil.csid.exposition.DTO.RepottingDTO;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;

public class EntityToRepottingMapper {

    public static Repotting mapFromEntity(RepottingEntity repottingEntity){
        return new Repotting(repottingEntity.getId(), repottingEntity.getDatetime(), EntityToBonsaiMapper.mapFromEntity(repottingEntity.getBonsaiEntity()));
    }

    public static Repotting mapFromDTO(RepottingDTO repottingDTO, Bonsai bonsai){
        return new Repotting(repottingDTO.getId(), repottingDTO.getDate(), bonsai);
    }

}
