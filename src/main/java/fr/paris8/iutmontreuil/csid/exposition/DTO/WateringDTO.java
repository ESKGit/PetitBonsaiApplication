package fr.paris8.iutmontreuil.csid.exposition.DTO;

import java.util.Date;
import java.util.UUID;

public class WateringDTO {

    private UUID uuid;
    private Date datetime;

    public WateringDTO() {
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDate() {
        return datetime;
    }

    public void setDate(Date datetime) {
        this.datetime = datetime;
    }

}