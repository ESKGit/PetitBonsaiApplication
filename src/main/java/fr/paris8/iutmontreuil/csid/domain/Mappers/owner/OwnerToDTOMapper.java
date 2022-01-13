package fr.paris8.iutmontreuil.csid.domain.Mappers.owner;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.owner.Owner;
import fr.paris8.iutmontreuil.csid.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.csid.exposition.DTO.OwnerDTO;

public class OwnerToDTOMapper {


        public static OwnerDTO mapFromOwner(Owner owner){
            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setId(owner.getId());
            ownerDTO.setName(owner.getName());
            ownerDTO.setBonsaiList(owner.getBonsaiList());
            return ownerDTO;
        }

    public static Owner mapfromDTO(OwnerDTO ownerDTO){
        return new Owner(ownerDTO.getId(), ownerDTO.getName(), ownerDTO.getBonsaiList());
    }

}
