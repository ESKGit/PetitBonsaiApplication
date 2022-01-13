package fr.paris8.iutmontreuil.csid.domain.Mappers.owner;

import fr.paris8.iutmontreuil.csid.domain.models.owner.Owner;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.OwnerEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OwnerToEntityMapper {

    public static OwnerEntity mapFromOwner(Owner owner)
    {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsaiEntityList(new ArrayList<BonsaiEntity>());

        return  ownerEntity;
    }

}
