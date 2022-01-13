package fr.paris8.iutmontreuil.csid.infrastructure.Dao;

import fr.paris8.iutmontreuil.csid.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {

    @Query("select bonsais from bonsai bonsais WHERE bonsais.owner_id=:uuidOwner2")
    List<BonsaiEntity> findAllWithOwnerID(@Param("uuidOwner2") UUID ownerUUID);

    @Modifying
    @Query("update bonsai set owner_id = :newOwnerID where id = :bonsaiID")
    void tranferOwner(@Param("bonsaiID") UUID bonsaiIDToTransfer, @Param("newOwnerID") UUID newOwnerID2);
}