package fr.paris8.iutmontreuil.csid.domain.Mappers.watering;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.watering.Watering;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.WateringEntity;

public class WateringToEntityMapper {
    public static WateringEntity mapFromWatering(Watering watering){
        WateringEntity wateringEntity = new WateringEntity();
        wateringEntity.setId(watering.getUuid());
        wateringEntity.setDatetime(watering.getDatetime());
        wateringEntity.setBonsai(BonsaiToEntityMapper.mapFromBonsai(watering.getBonsai()));
        return wateringEntity;
    }
}
