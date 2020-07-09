package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.DiseaseGroup;
import com.anamnesis.AnamnesisService.repository.DiseaseGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dg")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class DiseaseGroupController {
    @Autowired
    DiseaseGroupRepository dg;

    @GetMapping("/{id}")
    public DiseaseGroup getDiseaseGroupById(@PathVariable (value = "id") Integer id){
        return dg.findById(id).orElse(null);
    }

    @PostMapping
    public DiseaseGroup addDGrup(@RequestBody DiseaseGroup diseaseGroup){
        return dg.save(diseaseGroup);
    }
}
