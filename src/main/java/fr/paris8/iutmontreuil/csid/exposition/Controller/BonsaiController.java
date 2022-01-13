package fr.paris8.iutmontreuil.csid.exposition.Controller;

import fr.paris8.iutmontreuil.csid.domain.Mappers.prunning.PrunningToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.watering.WateringToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.Bonsai;
import fr.paris8.iutmontreuil.csid.domain.models.bonsai.BonsaiService;
import fr.paris8.iutmontreuil.csid.domain.Mappers.bonsai.BonsaiToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.Mappers.repotting.RepottingToDTOMapper;
import fr.paris8.iutmontreuil.csid.domain.models.prunning.PrunningService;
import fr.paris8.iutmontreuil.csid.domain.models.repotting.RepottingService;
import fr.paris8.iutmontreuil.csid.domain.models.watering.WateringService;
import fr.paris8.iutmontreuil.csid.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.csid.exposition.DTO.PrunningDTO;
import fr.paris8.iutmontreuil.csid.exposition.DTO.RepottingDTO;
import fr.paris8.iutmontreuil.csid.exposition.DTO.WateringDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private BonsaiService bonsaiService;
    private WateringService wateringService;
    private RepottingService repottingService;
    private PrunningService prunningService;

    public BonsaiController(BonsaiService bonsaiService, WateringService wateringService, RepottingService repottingService, PrunningService prunningService) {
        this.bonsaiService = bonsaiService;
        this.wateringService = wateringService;
        this.repottingService = repottingService;
        this.prunningService = prunningService;
    }

    @GetMapping()
    public ResponseEntity<List<BonsaiDTO>> findAll() {
        List<BonsaiDTO> bonsaisList = bonsaiService.findAll().stream()
                .map(bonsai -> BonsaiToDTOMapper.mapFromBonsai(bonsai))
                .collect(Collectors.toList());

        if (!bonsaisList.isEmpty())
            return ResponseEntity.ok(bonsaisList);
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {
        /*
        BonsaiDTO bonsaiDTO = BonsaiToDTOMapper.mapFromBonsai(bonsaiService.findById(uuid));
        return new ResponseEntity<BonsaiDTO>(bonsaiDTO, HttpStatus.OK);*/
        try {
            Bonsai bonsai = bonsaiService.findById(uuid);
            BonsaiDTO bonsaiDTO = BonsaiToDTOMapper.mapFromBonsai(bonsai);
            if (bonsaiDTO.getStatus() == null) {
                return ResponseEntity.status(HttpStatus.GONE).build();
            } else {
                return ResponseEntity.ok(bonsaiDTO);
            }
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping()
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsaiDTOClient) {
        Bonsai bonsai = bonsaiService.createBonsai(BonsaiToDTOMapper.mapfromDTO(bonsaiDTOClient));
        BonsaiDTO bonsaiDTO = BonsaiToDTOMapper.mapFromBonsai(bonsai);
        return new ResponseEntity<BonsaiDTO>(bonsaiDTO, HttpStatus.CREATED);
    }

    //curl -X DELETE -H 'Content-Type:application/json' http://localhost:8080/bonsai/{uuid}
    @DeleteMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> deleteById(@PathVariable("uuid") UUID uuid) {
        /*bonsaiService.deleteBonsaiById(uuid);
        return ResponseEntity.ok().build();*/
        try {
            bonsaiService.deleteBonsaiById(uuid);
            return ResponseEntity.noContent().build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

//curl -X PATCH -H 'Content-Type:application/json' http://localhost:8080/bonsai/{uuid}-d '{"name":"NAME_PATCH_TEST", "species":"tst_spc4", "acquisition_date":"2021-12-12", "acquisition_age":"21", "status":"alive"}'

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> patchBonsaiPartially(@PathVariable UUID uuid, @RequestBody BonsaiDTO bonsaiDTOClient) {
        try {
            Bonsai bonsai = bonsaiService.processPatch(BonsaiToDTOMapper.mapfromDTO(bonsaiDTOClient), uuid);
            BonsaiDTO bonsaiDTO = BonsaiToDTOMapper.mapFromBonsai(bonsai);
            return new ResponseEntity<BonsaiDTO>(bonsaiDTO, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{uuid}/status")
    public ResponseEntity<BonsaiDTO> putBonsai(@PathVariable("uuid") UUID uuid, @RequestBody String status) {
        try{
            bonsaiService.processPut(status, uuid);
            return ResponseEntity.ok().build();
        }catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}/watering")
    public List<WateringDTO> getAllWateringsFromBonsaiUUID(@PathVariable("uuid") UUID uuid) {
        return wateringService.findAll(uuid).stream()
                .map(watering -> WateringToDTOMapper.mapFromWatering(watering))
                .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}/repotting")
    public List<RepottingDTO> getAllRepottingFromBonsaiUUID(@PathVariable("uuid") UUID uuid) {
        return repottingService.findAll(uuid).stream()
                .map(repotting -> RepottingToDTOMapper.mapFromRepotting(repotting))
                .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}/prunning")
    public List<PrunningDTO> getAllPruningFromBonsaiUUID(@PathVariable("uuid") UUID uuid) {
        return prunningService.findAll(uuid).stream()
                .map(prunning -> PrunningToDTOMapper.mapFromPrunning(prunning))
                .collect(Collectors.toList());
    }
}