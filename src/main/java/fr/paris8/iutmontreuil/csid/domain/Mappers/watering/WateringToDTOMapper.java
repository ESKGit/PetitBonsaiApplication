package fr.paris8.iutmontreuil.csid.domain.Mappers.watering;

import fr.paris8.iutmontreuil.csid.domain.models.watering.Watering;
import fr.paris8.iutmontreuil.csid.exposition.DTO.WateringDTO;

public class WateringToDTOMapper {
    public static WateringDTO mapFromWatering(Watering watering){
        WateringDTO wateringDTO = new WateringDTO();
        wateringDTO.setId(watering.getUuid());
        wateringDTO.setDate(watering.getDatetime());
        return wateringDTO;
    }
}
