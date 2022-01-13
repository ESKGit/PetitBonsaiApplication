package fr.paris8.iutmontreuil.csid.domain.models.prunning;

import fr.paris8.iutmontreuil.csid.infrastructure.Repository.PrunningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrunningService {

    private PrunningRepository repository;

    public PrunningService(PrunningRepository repository) {
        this.repository = repository;
    }

    public Prunning save(Prunning prunning){
        return repository.save(prunning);
    }

    public List<Prunning> findAll(UUID bonsaiUUID){
        return repository.findAll(bonsaiUUID);
    }

}
