package fr.paris8.iutmontreuil.csid.infrastructure.Entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;
import java.util.Date;


@Entity(name = "bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String species;
    private String status;
    private Date acquisition_date;
    private Integer acquisition_age = 0;

    //Test
    private UUID owner_id;

    public BonsaiEntity(UUID uuid, String name, String species, String status, Date acquisition_date, Integer acquisition_age) {
        this.id = uuid;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
    }



    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public BonsaiEntity() { this.acquisition_age = 0; }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public Integer getAcquisition_age() {
        return acquisition_age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public void setAcquisition_age(Integer acquisition_age) {
        this.acquisition_age = acquisition_age;
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


}
