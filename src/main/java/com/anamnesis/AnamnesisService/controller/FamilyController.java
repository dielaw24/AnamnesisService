package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.Anamnesis;
import com.anamnesis.AnamnesisService.model.Family;
import com.anamnesis.AnamnesisService.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/family")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;

    @GetMapping
    public Iterable<Family> getAllFamily(){
        return familyRepository.findAll();
    }

    @GetMapping ("/{id_familiar}")
    public Family getFamilyById(@PathVariable(value="id_familiar") Integer id) {
        return familyRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Family dont found");
        });
    }
    @PostMapping
    public Family addFamily(@RequestBody  Family family) {
        return familyRepository.save(family);
    }
    @PutMapping
    public Family updateFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    @DeleteMapping("/{id_familiar}")
    public void deleteFamily(@PathVariable (value="id_familiar") Integer id) {
        if(familyRepository.findById(id).isPresent()) {
            familyRepository.delete(familyRepository.findById(id).get());
            //studentRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Family dont found");
        }
    }
}
