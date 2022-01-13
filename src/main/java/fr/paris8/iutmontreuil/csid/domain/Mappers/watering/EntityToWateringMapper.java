package fr.paris8.iutmontreuil.csid.domain.Mappers.watering;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.watering.Watering;
import fr.paris8.iutmontreuil.csid.exposition.DTO.WateringDTO;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.WateringEntity;

public class EntityToWateringMapper {

    public static Watering mapFromEntity(WateringEntity wateringEntity){
        return new Watering(wateringEntity.getId(), wateringEntity.getDatetime(), EntityToBonsaiMapper.mapFromEntity(wateringEntity.getBonsaiEntity()));
    }

    public static Watering mapFromDTO(WateringDTO wateringDTO, Bonsai bonsai){
        return new Watering(wateringDTO.getId(), wateringDTO.getDate(), bonsai);
    }

}
