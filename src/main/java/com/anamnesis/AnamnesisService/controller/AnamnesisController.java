package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.Anamnesis;
import com.anamnesis.AnamnesisService.repository.AnamnesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/anamnesis")
@CrossOrigin (origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AnamnesisController {

    @Autowired
    AnamnesisRepository anamnesisRepository;

    @GetMapping
    public Iterable<Anamnesis> getAllAnamnesis(){
        return anamnesisRepository.findAll();
    }

    @GetMapping ("/{id_anamnesis}")
    public Anamnesis getAnamnesisById(@PathVariable(value="id_anamnesis") Integer id) {
        return anamnesisRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        });
    }

    @GetMapping ("/{id_paciente}")
    public Anamnesis getAnamnesisByPateientId(@PathVariable(value="id_paciente") Integer id) {
        return anamnesisRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        });
    }


    @PostMapping
    public Anamnesis addAnamnesis(@RequestBody  Anamnesis anamnesis) {
        return anamnesisRepository.save(anamnesis);
    }

    @PutMapping
    public Anamnesis updateAnamnesis(@RequestBody Anamnesis anamnesis) {
        return anamnesisRepository.save(anamnesis);
    }

    @DeleteMapping("/{id_anamnesis}")
    public void deleteAnamnesis(@PathVariable (value="id_anamnesis") Integer id) {
        if(anamnesisRepository.findById(id).isPresent()) {
            anamnesisRepository.delete(anamnesisRepository.findById(id).get());
            //studentRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anamnesis dont found");
        }
    }







}
