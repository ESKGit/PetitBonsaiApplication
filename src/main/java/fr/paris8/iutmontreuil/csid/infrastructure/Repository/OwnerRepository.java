package fr.paris8.iutmontreuil.csid.infrastructure.Repository;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.owner.EntityToOwnerMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.owner.OwnerToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.owner.Owner;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.BonsaiDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Dao.OwnerDao;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.OwnerEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OwnerRepository {

    private OwnerDao ownerDao;
    private BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaiDao)
    {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }


    public List<Owner> findAll(int has_more)
    {
        List<Owner> ownerList = ownerDao.findAllHasMore(has_more).stream().map(EntityToOwnerMapper::mapFromEntity).collect(Collectors.toList());
        return  ownerList;
    }

    public List<Bonsai> findAllBonsais(UUID uuid)
    {
        List<Bonsai> bonsaiList = bonsaiDao.findAllWithOwnerID(uuid).stream().map(EntityToBonsaiMapper::mapFromEntity).collect(Collectors.toList());
        return bonsaiList;
    }


    public Owner findById(UUID uuid)
    {
        Optional<OwnerEntity> ownerEntity = ownerDao.findById(uuid);

        return ownerEntity.map(EntityToOwnerMapper::mapFromEntity).orElse(null);
    }

    public Owner save(Owner owner) {
        OwnerEntity ownerEntity = ownerDao.save(OwnerToEntityMapper.mapFromOwner(owner));
        return EntityToOwnerMapper.mapFromEntity(ownerEntity);

    }

    @Transactional
    public Optional<Bonsai> tranfer(Optional<Owner> newOwner, UUID bonsaiIDToTransfer)
    {
        bonsaiDao.tranferOwner(bonsaiIDToTransfer, newOwner.get().getId());
        bonsaiDao.findById(bonsaiIDToTransfer);

        return bonsaiDao.findById(bonsaiIDToTransfer).map(EntityToBonsaiMapper::mapFromEntity);
    }


    public Optional<Bonsai> findBonsaiById(UUID bonsaiIDToTransfer)
    {
        return bonsaiDao.findById(bonsaiIDToTransfer).map(EntityToBonsaiMapper::mapFromEntity);
    }
    public Optional<Owner> findOwnerById(UUID newOwnerUUID)
    {
        return ownerDao.findById(newOwnerUUID).map(EntityToOwnerMapper::mapFromEntity);
    }

    @Transactional
    public Bonsai addBonsai(Owner owner, Bonsai bonsai) {
        ownerDao.addBonsaiToOwner(owner.getId(), bonsai.getId());
        return bonsai;
    }
}
