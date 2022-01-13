package fr.paris8.iutmontreuil.csid.infrastructure.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = BonsaiEntity.class, mappedBy = "owner_id",cascade = CascadeType.DETACH )
    private List<BonsaiEntity> bonsaiEntityList;

    public OwnerEntity() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BonsaiEntity> getBonsaiEntityList() {
        if(bonsaiEntityList == null)
        {
         bonsaiEntityList = new ArrayList<>();
        }
            return bonsaiEntityList;
    }

    public void setBonsaiEntityList(List<BonsaiEntity> bonsaiEntityList) {

        this.bonsaiEntityList = bonsaiEntityList;
    }



}

