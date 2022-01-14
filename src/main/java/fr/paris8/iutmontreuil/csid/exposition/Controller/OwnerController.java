package fr.paris8.iutmontreuil.csid.exposition.Controller;


import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.owner.OwnerToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.owner.Owner;
import fr.paris8.iutmontreuil.csid.domain.models.owner.OwnerService;
import fr.paris8.iutmontreuil.csid.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.csid.exposition.DTO.OwnerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService)
    {
        this.ownerService = ownerService;
    }


    @GetMapping()
    public List<OwnerDTO> findAllWithMoreThan(@RequestParam int has_more)
    {
        return ownerService.findAll(has_more).stream()
                .map(owner -> OwnerToDTOMapper.mapFromOwner(owner))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable("id") UUID uuid)
    {
        OwnerDTO ownerDTO = OwnerToDTOMapper.mapFromOwner(ownerService.findById(uuid));

        return new ResponseEntity<OwnerDTO>(ownerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/bonsais")
    public ResponseEntity<List<BonsaiDTO>> findBonsaisByOwnerID(@PathVariable("id") UUID uuid)
    {
        List<BonsaiDTO> bonsaiDTOList = ownerService.findAllBonsais(uuid).stream().map(BonsaiToDTOMapper::mapFromBonsai).collect(Collectors.toList());

        return new ResponseEntity<List<BonsaiDTO>>(bonsaiDTOList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OwnerDTO> create(@RequestBody String ownerName)
    {

        OwnerDTO ownerDTOname = new OwnerDTO();
        ownerDTOname.setName(ownerName);

        Owner owner = ownerService.create(OwnerToDTOMapper.mapfromDTO(ownerDTOname));

        OwnerDTO ownerDTO = OwnerToDTOMapper.mapFromOwner(owner);

        return new ResponseEntity<OwnerDTO>(ownerDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> tranferToOwner(@PathVariable("owner_id") UUID currentOwnerID, @PathVariable("bonsai_id") UUID bonsaiIDToTransfer, @RequestBody OwnerDTO newOwnerDTO)
    {

        Optional<Bonsai> bonsai = ownerService.tranferBonsaiToNewOwner(currentOwnerID, bonsaiIDToTransfer, newOwnerDTO);

        BonsaiDTO bonsaiDTO = BonsaiToDTOMapper.mapFromBonsai(bonsai.get());

        return new ResponseEntity<BonsaiDTO>(bonsaiDTO, HttpStatus.CREATED);
    }


    @PostMapping(value = "/{owner_id}/bonsais")
    public ResponseEntity<List<BonsaiDTO>> addBonsaisToOwner(@PathVariable("owner_id") UUID owner_id, @RequestBody List<Bonsai> bonsaiList)
    {
        List<BonsaiDTO> bonsaiDTOList = ownerService.addBonsai(owner_id, bonsaiList).stream().map(BonsaiToDTOMapper::mapFromBonsai).collect(Collectors.toList());

        return new ResponseEntity<List<BonsaiDTO>>(bonsaiDTOList, HttpStatus.OK);
    }

}
