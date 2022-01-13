package fr.paris8.iutmontreuil.csid.domain.Mappers.prunning;

import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToEntityMapper;
import fr.paris8.iutmontreuil.csid.domain.models.prunning.Prunning;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.PrunningEntity;

public class PrunningToEntityMapper {
    public static PrunningEntity mapFromPrunning(Prunning prunning){
        PrunningEntity prunningEntity = new PrunningEntity();
        prunningEntity.setId(prunning.getUuid());
        prunningEntity.setDatetime(prunning.getDatetime());
        prunningEntity.setBonsai(BonsaiToEntityMapper.mapFromBonsai(prunning.getBonsai()));
        return prunningEntity;
    }
}
