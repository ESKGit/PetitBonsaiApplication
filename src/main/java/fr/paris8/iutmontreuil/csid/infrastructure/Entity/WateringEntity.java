package fr.paris8.iutmontreuil.csid.infrastructure.Entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Embeddable
@Entity(name = "watering")
@Table(name = "watering")
public class WateringEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(name = "datetime")
    private Date datetime;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;

    public WateringEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date ddatetimeate) {
        this.datetime = datetime;
    }

    public BonsaiEntity getBonsaiEntity() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }

}