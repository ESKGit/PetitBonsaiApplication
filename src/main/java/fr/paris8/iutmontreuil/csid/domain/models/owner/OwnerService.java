package fr.paris8.iutmontreuil.csid.domain.models.owner;

import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.exposition.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.csid.infrastructure.Repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private OwnerRepository repository;

    public OwnerService(OwnerRepository repository)
    {
        this.repository = repository;
    }

    public List<Owner> findAll(int has_more) {

        return repository.findAll(has_more);
    }

    public List<Bonsai> findAllBonsais(UUID uuid) {

        return repository.findAllBonsais(uuid);
    }

    public Owner findById(UUID uuid)
    {
        return repository.findById(uuid);
    }

    public Owner create(Owner owner) {

        return repository.save(owner);
    }

    public Optional<Bonsai> tranferBonsaiToNewOwner(UUID currentOwnerID, UUID bonsaiIDToTransfer, OwnerDTO newOwnerDTO)
    {
        Optional<Bonsai> bonsai = repository.findBonsaiById(bonsaiIDToTransfer);
        Optional<Owner> newOwner = repository.findOwnerById(newOwnerDTO.getId());

        return repository.tranfer(newOwner, bonsaiIDToTransfer);
    }


}
