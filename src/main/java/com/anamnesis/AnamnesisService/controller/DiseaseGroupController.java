package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.DiseaseGroup;
import com.anamnesis.AnamnesisService.repository.DiseaseGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/dg")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class DiseaseGroupController {
    @Autowired
    DiseaseGroupRepository dg;

    //obtener todos los grupos de enfermedades
    @GetMapping
    public Iterable<DiseaseGroup> getAllDiseaseGroups() {
        return dg.findAll();
    }
    // obtener un grupo de enfermedad por id
    @GetMapping("/{id}")
    public DiseaseGroup getDiseaseGroupById(@PathVariable (value = "id") String id){
        return dg.findById(id).orElse(null);
    }
    // agregar un grupo de enfermedad
    @PostMapping
    public DiseaseGroup addDGrup(@RequestBody DiseaseGroup diseaseGroup){
        return dg.save(diseaseGroup);
    }
    // actualizar grupo de enfermedad
    @PutMapping
    public DiseaseGroup updateDGrup(@RequestBody DiseaseGroup diseaseGroup){
        return dg.save(diseaseGroup);
    }

    //eliminar un grupo de enfermedad por id
    @DeleteMapping("/{id_dg}")
    public void deleteDiseaseGroup(@PathVariable (value = "id_dg") String id){
        if(dg.findById(id).isPresent()){
            dg.delete((dg.findById(id).get()));
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"DiseaseGroup dont found");
        }
    }
}
