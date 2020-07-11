package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.RegistryAnamnesis;
import com.anamnesis.AnamnesisService.repository.RegistryAnamnesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RegistryAnamnesisController {
    @Autowired
    RegistryAnamnesisRepository registryAnamnesisRepository;
    // Obtener todos los Registros de anamnesis
    @GetMapping
    public Iterable<RegistryAnamnesis> getAllRegisters(){
        return registryAnamnesisRepository.findAll();
    }
    //Obtener un registro de anamnesis por id
    @GetMapping("/{id_register}")
    public RegistryAnamnesis getRegisterById(@PathVariable(value = "id_register")Integer id){
        return registryAnamnesisRepository.findById(id).orElseGet(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Register dont found");
        });
    }
    // agregar un registro de anamnesis
    @PostMapping
    public RegistryAnamnesis addRegister(@RequestBody RegistryAnamnesis registryAnamnesis){
        return registryAnamnesisRepository.save(registryAnamnesis);
    }
    // actualizar un registro de anamnesis
    @PutMapping
    public RegistryAnamnesis updateRegister(@RequestBody RegistryAnamnesis registryAnamnesis){
        return registryAnamnesisRepository.save(registryAnamnesis);
    }
    // eliminar un registro de anamnesis por id
    @DeleteMapping("/{id_register}")
    public void deleteRegister(@PathVariable(value = "id_register") Integer id){
        if(registryAnamnesisRepository.findById(id).isPresent()){
            registryAnamnesisRepository.delete(registryAnamnesisRepository.findById(id).get());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Register dont found");
        }
    }

}
