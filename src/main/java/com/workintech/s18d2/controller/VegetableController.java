package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {
    private final VegetableService vegetableService;
    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vegetable>> getFruits(){
        List<Vegetable> allVegetablesByPrice = vegetableService.findAllVegetableAscByPrice();
        return new ResponseEntity<>(allVegetablesByPrice, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable Long id){
        Vegetable vegetable  = vegetableService.getVegetableById(id);
        return ResponseEntity.ok(vegetable);
    }
    @GetMapping("/desc")
    public ResponseEntity<List<Vegetable>> getFruitsDesc(){
        List<Vegetable> allVegetablesByPrice = vegetableService.findAllVegetableDescByPrice();
        return ResponseEntity.ok(allVegetablesByPrice);
    }
    @PostMapping("/")
    public ResponseEntity<Vegetable> updateOrInsertFruit(@RequestBody Vegetable vegetable){
        Vegetable newVegetable = vegetableService.updateOrInsertVegetable(vegetable);
        return ResponseEntity.ok(newVegetable);
    }
    @PostMapping("/{name}")
    public ResponseEntity<List<Vegetable>> getVegetablesLikeName(@PathVariable String name){
        List<Vegetable> allVegetablesLikeName = vegetableService.findVegetablesByLikeName(name);
        return ResponseEntity.ok(allVegetablesLikeName);
    }
    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable Long id){
        vegetableService.deleteVegetable(id);
    }
}
