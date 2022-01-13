package fr.paris8.iutmontreuil.csid.infrastructure.Repository;


import fr.paris8.iutmontreuil.csid.domain.Mappers.prunning.EntityToPrunningMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.prunning.PrunningToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.prunning.Prunning;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.PrunningDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.PrunningEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PrunningRepository {

    private PrunningDao prunningDao;

    public PrunningRepository(PrunningDao prunningDao)
    {
        this.prunningDao = prunningDao;
    }

    public List<Prunning> findAll(UUID bonsaiUUID)
    {
        List<PrunningEntity> filterdPrunningEntityList = prunningDao.findAllByBonsaiId(bonsaiUUID);

        List<Prunning> prunningList = new ArrayList<>();

        for (PrunningEntity prunningEntity : filterdPrunningEntityList)
            prunningList.add(EntityToPrunningMapper.mapFromEntity(prunningEntity));

        return prunningList;
    }

    public Prunning save(Prunning prunning){
        PrunningEntity prunningEntity = prunningDao.save(PrunningToEntityMapper.mapFromPrunning(prunning));
        return EntityToPrunningMapper.mapFromEntity(prunningEntity);
    }


}