package fr.paris8.iutmontreuil.csid.domain.models.watering;

import fr.paris8.iutmontreuil.csid.infrastructure.Repository.WateringRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WateringService {

    private WateringRepository repository;

    public WateringService(WateringRepository repository) {
        this.repository = repository;
    }

    public Watering save(Watering watering){
        return repository.save(watering);
    }

    public List<Watering> findAll(UUID bonsaiUUID){
        return repository.findAll(bonsaiUUID);
    }

}