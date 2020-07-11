package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.NoPathologicalPersonalHistory;
import com.anamnesis.AnamnesisService.repository.NoPatPersonalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/nopatpersonalhistory")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class NoPathologicalPersonalHistoryController {
    @Autowired
    NoPatPersonalHistoryRepository noPatPersonalHistoryRepository;
    // obtener todos los antecedentes personales no patologicos
    @GetMapping
    public Iterable<NoPathologicalPersonalHistory> getAllNoPatologicalPersonalHistory(){
        return  noPatPersonalHistoryRepository.findAll();
    }
    // obtener un antecedentes personales no patologicos por id
    @GetMapping("/{id_nopat_personal_hist}")
    public NoPathologicalPersonalHistory getNoPatPersonalHistoryById(@PathVariable(value = "id_nopat_personal_hist") Integer id){
        return noPatPersonalHistoryRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NoPatologicalPersonalHistory dont found");
        });
    }
    // agregar un antecedentes personales no patologicos
    @PostMapping
    public NoPathologicalPersonalHistory addNoPatPersonalHistory(@RequestBody NoPathologicalPersonalHistory noPathologicalPersonalHistory){
        return noPatPersonalHistoryRepository.save(noPathologicalPersonalHistory);
    }
    // actualizar un antecedentes personales no patologicos
    @PutMapping
    public NoPathologicalPersonalHistory updateNoPatPersonalHistory(@RequestBody NoPathologicalPersonalHistory noPathologicalPersonalHistory){
        return noPatPersonalHistoryRepository.save(noPathologicalPersonalHistory);
    }
    // eliminar un antecedentes personales no patologicos por id

    public void deleteNoPatPersonalHistory(@PathVariable(value = "id_nopat_personal_hist") Integer id){
        if(noPatPersonalHistoryRepository.findById(id).isPresent()){
            noPatPersonalHistoryRepository.delete(noPatPersonalHistoryRepository.findById(id).get());
        }  else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"NoPatologicalPersonalHistory dont found");
        }
    }

}
