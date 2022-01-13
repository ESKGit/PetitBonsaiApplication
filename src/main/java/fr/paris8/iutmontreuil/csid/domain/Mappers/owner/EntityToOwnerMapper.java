package fr.paris8.iutmontreuil.csid.domain.Mappers.owner;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.domain.models.owner.Owner;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.OwnerEntity;

import java.util.stream.Collectors;

public class EntityToOwnerMapper {

    public static Owner mapFromEntity(OwnerEntity ownerEntity)
    {
        Owner owner = new Owner();

        owner.setId(ownerEntity.getId());
        owner.setName(ownerEntity.getName());
        owner.setBonsaiList(ownerEntity.getBonsaiEntityList().stream()
                .map(EntityToBonsaiMapper::mapFromEntity)
                .collect(Collectors.toList()));

        return owner;
    }
}
