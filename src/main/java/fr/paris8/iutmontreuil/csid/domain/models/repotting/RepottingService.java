package fr.paris8.iutmontreuil.csid.domain.models.repotting;

import fr.paris8.iutmontreuil.csid.infrastructure.Repository.RepottingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RepottingService {

    private RepottingRepository repository;

    public RepottingService(RepottingRepository repository) {
        this.repository = repository;
    }

    public Repotting save(Repotting watering){
        return repository.save(watering);
    }

    public List<Repotting> findAll(UUID bonsaiUUID){
        return repository.findAll(bonsaiUUID);
    }

}
