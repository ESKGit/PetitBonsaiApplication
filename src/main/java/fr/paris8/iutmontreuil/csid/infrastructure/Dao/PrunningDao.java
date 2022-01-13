package fr.paris8.iutmontreuil.csid.infrastructure.Dao;

import fr.paris8.iutmontreuil.csid.infrastructure.Entity.PrunningEntity;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PrunningDao extends JpaRepository<PrunningEntity, UUID> {
    @Query("select prunnings from prunning prunnings WHERE prunnings.bonsai.id=:uuidBonsai2 order by prunnings.datetime DESC")
    List<PrunningEntity> findAllByBonsaiId(@Param("uuidBonsai2") UUID bonsaiUUID);
}
