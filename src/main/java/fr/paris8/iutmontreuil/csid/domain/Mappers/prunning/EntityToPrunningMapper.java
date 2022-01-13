package fr.paris8.iutmontreuil.csid.domain.Mappers.prunning;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.EntityToBonsaiMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.prunning.Prunning;
import fr.paris8.iutmontreuil.csid.exposition.DTO.PrunningDTO;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.PrunningEntity;

public class EntityToPrunningMapper {

    public static Prunning mapFromEntity(PrunningEntity prunningEntity){
        return new Prunning(prunningEntity.getId(), prunningEntity.getDatetime(), EntityToBonsaiMapper.mapFromEntity(prunningEntity.getBonsaiEntity()));
    }

    public static Prunning mapFromDTO(PrunningDTO prunningDTO, Bonsai bonsai){
        return new Prunning(prunningDTO.getId(), prunningDTO.getDate(), bonsai);
    }

}
