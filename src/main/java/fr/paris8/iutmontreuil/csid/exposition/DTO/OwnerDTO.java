package fr.paris8.iutmontreuil.csid.exposition.DTO;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;

import java.util.List;
import java.util.UUID;

public class OwnerDTO {


    private UUID id;
    private String name;
    private List<Bonsai> bonsaiList;



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

    public List<Bonsai> getBonsaiList() {
        return bonsaiList;
    }

    public void setBonsaiList(List<Bonsai> bonsaiList) {
        this.bonsaiList = bonsaiList;
    }


}
