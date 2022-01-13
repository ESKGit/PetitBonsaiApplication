package fr.paris8.iutmontreuil.csid.domain.models.prunning;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;

import java.util.Date;
import java.util.UUID;

public class Prunning {

    private UUID uuid;
    private Date datetime;
    private Bonsai bonsai;

    public Prunning(UUID uuid, Date datetime, Bonsai bonsai)
    {
        this.uuid = uuid;
        this.datetime = datetime;
        this.bonsai = bonsai;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }

}
