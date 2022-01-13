package fr.paris8.iutmontreuil.csid.domain.models.bonsai;

import java.util.Date;
import java.util.UUID;

public class Bonsai {

    private UUID id;
    private String name;
    private String species;
    private String status;
    private Date acquisition_date;
    private int acquisition_age;


    public Bonsai(UUID id, String name, String species, String status, Date acquisition_date, int acquisition_age) {
        this.id=id;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
    }

    public Bonsai update(Bonsai bonsai)
    {
        if (bonsai.getName() != null){ this.name = bonsai.getName(); }
        if (bonsai.getSpecies()!= null){  this.species = bonsai.getSpecies(); }
        if (bonsai.getAcquisition_date()!= null){ this.acquisition_date = bonsai.getAcquisition_date(); }
        if (bonsai.getAcquisition_age()!= 0){ this.acquisition_age = bonsai.getAcquisition_age(); }
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getStatus() {
        return status;
    }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

}
