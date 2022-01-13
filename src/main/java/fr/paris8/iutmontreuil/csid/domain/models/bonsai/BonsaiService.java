package fr.paris8.iutmontreuil.csid.domain.models.bonsai;


import org.springframework.stereotype.Service;
import fr.paris8.iutmontreuil.csid.infrastructure.Repository.BonsaiRepository;

import java.util.List;
import java.util.UUID;
/*
processPut
        processPatch
        deleteBonsaiById
        findById
        createBonsai
        findAll
*/

@Service
public class BonsaiService {

    private BonsaiRepository repository;

    public BonsaiService(BonsaiRepository repo){
        this.repository=repo;
    }

    public Bonsai findById(UUID id) {
        return repository.findById(id);
    }

    public List<Bonsai> findAll() {
        return repository.findAll();
    }

    public Bonsai createBonsai(Bonsai bonsai) {
        return repository.save(bonsai);
    }

    public void deleteBonsaiById(UUID id) {
        repository.deleteBonsaiById(id);
    }

    public Bonsai processPatch(Bonsai bonsai, UUID id) {
        return createBonsai(repository.findById(id).update(bonsai));
    }

    public void processPut(String status, UUID id) {
        Bonsai bonsai = findById(id);
        bonsai.setStatus(status);
        repository.save(bonsai);
    }


}
