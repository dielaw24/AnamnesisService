package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.Work;
import com.anamnesis.AnamnesisService.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/work")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class WorkController {
    @Autowired
    WorkRepository workRepository;

    @GetMapping
    public Iterable<Work> getAllWorks(){
        return workRepository.findAll();
    }

    @GetMapping ("/{id_trabajo}")
    public Work getWorkById(@PathVariable(value="id_trabajo") Integer id) {
        return workRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Work dont found");
        });
    }
    @PostMapping
    public Work addWork(@RequestBody Work work) {
        return workRepository.save(work);
    }
    @PutMapping
    public Work updateWork(@RequestBody Work work) {
        return workRepository.save(work);
    }

    @DeleteMapping("/{id_trabajo}")
    public void deleteWork(@PathVariable (value="id_trabajo") Integer id) {
        if(workRepository.findById(id).isPresent()) {
            workRepository.delete(workRepository.findById(id).get());
            //studentRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Work dont found");
        }
    }

}
