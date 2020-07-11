package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.WorkHistory;
import com.anamnesis.AnamnesisService.repository.WorkHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/workhistory")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class WorkHistoryController {
    @Autowired
    WorkHistoryRepository workHistoryRepository;
    //obtener todos los antecedentes laborales
    @GetMapping
    public Iterable<WorkHistory> getAllWorkHistories(){
        return workHistoryRepository.findAll();
    }

    // obtener antecedentes laborales por id
    @GetMapping("/{id_workhist}")
    public WorkHistory getWorkHistoryById(@PathVariable(name = "id_workhist") Integer id){
        return workHistoryRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"WorkHistory dont found");
        });
    }

    // agregar antecedentes laborales
    @PostMapping
    public WorkHistory addWorkHistory(@RequestBody WorkHistory workHistory){
        return workHistoryRepository.save(workHistory);
    }

    //actualizar antecedentes laborales
    @PutMapping
    public WorkHistory updateWorkHistory(@RequestBody WorkHistory workHistory){
        return workHistoryRepository.save(workHistory);
    }
    // eliminar antecedentes laborales por id
    @DeleteMapping("/{id_workhist}")
    public void deleteWorkHistory(@PathVariable(value = "id_workhist") Integer id){
        if(workHistoryRepository.findById(id).isPresent()) {
            workHistoryRepository.delete(workHistoryRepository.findById(id).get());

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"WorkHistory dont found");
        }
    }
}
