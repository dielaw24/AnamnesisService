package com.anamnesis.AnamnesisService.controller;

import com.anamnesis.AnamnesisService.model.HousingConditions;
import com.anamnesis.AnamnesisService.repository.HousingConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/housingcondition")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class HousingConditionsController {
   @Autowired
   HousingConditionsRepository housingConditionsRepository;

   //obtener todos las condiciones de vivienda
   @GetMapping
   public Iterable<HousingConditions> getAllHousingConditions(){
       return housingConditionsRepository.findAll();
   }
   // obtener condicion de vivienda por id
   @GetMapping("/{id_house_cond}")
   public HousingConditions getHouseConditionsById(@PathVariable (value = "id_housing_cond") Integer id){
       return  housingConditionsRepository.findById(id).orElseGet(() -> {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"HousingCondition dont found");
       });
   }
   // agregar condiciones de vivienda
   @PostMapping
   public HousingConditions addHouseConditions(@RequestBody HousingConditions housing_conditions){
       return housingConditionsRepository.save(housing_conditions);
   }
   // actualizar condiciones de vivienda
   @PutMapping
   public HousingConditions updateHouseConditions(@RequestBody HousingConditions housing_conditions){
       return housingConditionsRepository.save(housing_conditions);
   }
   // eliminar condiciones de vivienda por id
   @DeleteMapping("/{id_house_cond}")
   public void deleteHousingConditions(@PathVariable(value = "id_house_cond") Integer id){
       if(housingConditionsRepository.findById(id).isPresent()){
           housingConditionsRepository.delete(housingConditionsRepository.findById(id).get());
       }else {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"HousingCondition dont found");
       }
   }


}
