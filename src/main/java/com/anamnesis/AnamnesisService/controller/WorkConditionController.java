package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.Work;
import com.anamnesis.AnamnesisService.repository.WorkConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/work")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class WorkConditionController {
    @Autowired
    WorkConditionRepository workConditionRepository;

    @GetMapping
    public Iterable<Work> getAllWorks(){
        return workConditionRepository.findAll();
    }

    @GetMapping ("/{id_trabajo}")
    public Work getWorkById(@PathVariable(value="id_trabajo") Integer id) {
        return workConditionRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Work dont found");
        });
    }
    @PostMapping
    public Work addWork(@RequestBody Work work) {
        return workConditionRepository.save(work);
    }
    @PutMapping
    public Work updateWork(@RequestBody Work work) {
        return workConditionRepository.save(work);
    }

    @DeleteMapping("/{id_trabajo}")
    public void deleteWork(@PathVariable (value="id_trabajo") Integer id) {
        if(workConditionRepository.findById(id).isPresent()) {
            workConditionRepository.delete(workConditionRepository.findById(id).get());
            //studentRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Work dont found");
        }
    }

}
