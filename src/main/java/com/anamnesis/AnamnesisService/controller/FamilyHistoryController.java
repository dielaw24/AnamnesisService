package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.Family;
import com.anamnesis.AnamnesisService.model.FamilyHistory;
import com.anamnesis.AnamnesisService.repository.FamilyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/familyhistory")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FamilyHistoryController {
    @Autowired
    FamilyHistoryRepository familyHistoryRepository;

    //obtener todos los antecedentes familiares
    @GetMapping
    public Iterable<FamilyHistory> getAllFamilyHistories(){
        return familyHistoryRepository.findAll();
    }

    //Obtener antecedente familiar por id
    @GetMapping("/{id_ant_familiar}")
    public FamilyHistory getFamiliyHistoryById(@PathVariable(value = "id_ant_familiar") Integer id){
        return familyHistoryRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"FamilyHistory dont found");
        });
    }
    // agregar un antecedente familiar
    @PostMapping
    public FamilyHistory addFamilyHistory(@RequestBody FamilyHistory familyHistory){
        return familyHistoryRepository.save(familyHistory);
    }
    // actualizar un antecedente familiar
    @PutMapping
    public FamilyHistory updateFamilyHistory(@RequestBody FamilyHistory familyHistory){
        return familyHistoryRepository.save(familyHistory);
    }
    // eliminar antecedente familiar por id
    @DeleteMapping("/{id_ant_familiar}")
    public void  deleteFamilyHistory(@PathVariable (value = "id_ant_familiar") Integer id){
        if(familyHistoryRepository.findById(id).isPresent()){
            familyHistoryRepository.delete(familyHistoryRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"FamilyHistory dont found");
        }
    }

}
