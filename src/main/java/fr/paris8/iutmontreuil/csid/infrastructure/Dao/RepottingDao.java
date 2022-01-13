package fr.paris8.iutmontreuil.csid.infrastructure.Dao;

import fr.paris8.iutmontreuil.csid.infrastructure.Entity.RepottingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepottingDao extends JpaRepository<RepottingEntity, UUID> {
    @Query("select repottings from repotting repottings WHERE repottings.bonsai.id=:uuidBonsai2 order by repottings.datetime DESC")
    List<RepottingEntity> findAllByBonsaiId(@Param("uuidBonsai2") UUID bonsaiUUID);
}
