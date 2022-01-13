package fr.paris8.iutmontreuil.csid.infrastructure.Repository;


import fr.paris8.iutmontreuil.csid.domain.Mappers.repotting.EntityToRepottingMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.repotting.RepottingToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.repotting.Repotting;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.RepottingDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class RepottingRepository {

    private RepottingDao repottingDao;

    public RepottingRepository(RepottingDao repottingDao)
    {
        this.repottingDao = repottingDao;
    }

    public List<Repotting> findAll(UUID bonsaiUUID)
    {
        List<RepottingEntity> filterdWateringEntityList = repottingDao.findAllByBonsaiId(bonsaiUUID);

        List<Repotting> repottingList = new ArrayList<>();

        for (RepottingEntity repottingEntity : filterdWateringEntityList)
            repottingList.add(EntityToRepottingMapper.mapFromEntity(repottingEntity));

        return repottingList;
    }

    public Repotting save(Repotting repotting){
        RepottingEntity repottingEntity = repottingDao.save(RepottingToEntityMapper.mapFromRepotting(repotting));
        return EntityToRepottingMapper.mapFromEntity(repottingEntity);
    }
}