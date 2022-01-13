package fr.paris8.iutmontreuil.csid.infrastructure.Repository;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.BonsaiDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
findById(UUID uuid)
findAll()
save(Bonsai bonsai)
deleteBonsaiById(UUID uuid)

 */
@Component
public class BonsaiRepository {

    private BonsaiDao bonsaisDao;

    public BonsaiRepository(BonsaiDao dao){
        this.bonsaisDao = dao;
    }

    public List<Bonsai> findAll()
    {
        List<BonsaiEntity> bonsaiEntityList = bonsaisDao.findAll();

        List<Bonsai> bonsaisList = new ArrayList<>();
        for (BonsaiEntity bonsaiEntity : bonsaiEntityList){
            bonsaisList.add(EntityToBonsaiMapper.mapFromEntity(bonsaiEntity));
        }

        return bonsaisList;
    }


    public Bonsai findById(UUID uuid)
    {
        Optional<BonsaiEntity> bonsaiEntity = bonsaisDao.findById(uuid);

        return bonsaiEntity.map(EntityToBonsaiMapper::mapFromEntity).orElse(null);
    }

    public Bonsai save(Bonsai bonsai)
    {
        BonsaiEntity bonsaiEntity = BonsaiToEntityMapper.mapFromBonsai(bonsai);
        bonsaisDao.save(bonsaiEntity);

        Bonsai nvBonsai = EntityToBonsaiMapper.mapFromEntity(bonsaiEntity);
        return nvBonsai;
    }

    public void deleteBonsaiById(UUID uuid)
    {
        bonsaisDao.deleteById(uuid);
    }

}
