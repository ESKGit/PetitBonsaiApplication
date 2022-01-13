package fr.paris8.iutmontreuil.csid.infrastructure.Dao;

import fr.paris8.iutmontreuil.csid.infrastructure.Entity.WateringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WateringDao extends JpaRepository<WateringEntity, UUID> {
    @Query("select waterings from watering waterings WHERE waterings.bonsai.id=:uuidBonsai order by waterings.datetime DESC")
    List<WateringEntity> findAllByBonsaiId(@Param("uuidBonsai") UUID bonsaiUUID);
}