package fr.paris8.iutmontreuil.csid.infrastructure.Dao;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.BonsaiEntity;
import fr.paris8.iutmontreuil.csid.infrastructure.Entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface OwnerDao extends JpaRepository<OwnerEntity, UUID> {

    @Query("SELECT o FROM owner o, bonsai b WHERE (:has_more = -1 OR o.id = b.owner_id) GROUP BY o HAVING COUNT(b) > :has_more")
    List<OwnerEntity> findAllHasMore(@Param("has_more") int has_more);


    @Modifying
    @Query("UPDATE bonsai SET owner_id = :owner_id WHERE id = :bonsai_id")
    void addBonsaiToOwner(@Param("owner_id") UUID owner_id, @Param("bonsai_id") UUID bonsai_id);
}