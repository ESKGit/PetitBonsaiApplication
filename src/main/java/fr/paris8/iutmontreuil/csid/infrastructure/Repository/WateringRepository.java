package fr.paris8.iutmontreuil.csid.infrastructure.Repository;


import fr.paris8.iutmontreuil.csid.domain.Mappers.watering.EntityToWateringMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.watering.WateringToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.watering.Watering;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.WateringDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.WateringEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class WateringRepository {

    private WateringDao wateringDao;

    public WateringRepository(WateringDao wateringDao)
    {
        this.wateringDao = wateringDao;
    }

    public List<Watering> findAll(UUID bonsaiUUID)
    {
        List<WateringEntity> filterdWateringEntityList = wateringDao.findAllByBonsaiId(bonsaiUUID);

        List<Watering> wateringList = new ArrayList<>();

        for (WateringEntity wateringEntity : filterdWateringEntityList)
            wateringList.add(EntityToWateringMapper.mapFromEntity(wateringEntity));

        return wateringList;
    }

    public Watering save(Watering watering){
        WateringEntity wateringEntity = wateringDao.save(WateringToEntityMapper.mapFromWatering(watering));
        return EntityToWateringMapper.mapFromEntity(wateringEntity);
    }
}