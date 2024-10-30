package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/fruits")
public class FruitController {
    private final FruitService fruitService;
    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Fruit>> getFruits(){
        List<Fruit> allFruitByPrice = fruitService.findAllFruitAscByPrice();
        return new ResponseEntity<>(allFruitByPrice, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id){
        Fruit fruit  = fruitService.getFruitById(id);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }
    @GetMapping("/desc")
    public ResponseEntity<List<Fruit>> getFruitsDesc(){
        List<Fruit> allFruitByPrice = fruitService.findAllFruitDescByPrice();
        return ResponseEntity.ok(allFruitByPrice);
    }
    @PostMapping("/")
    public ResponseEntity<Fruit> updateOrInsertFruit(@RequestBody Fruit fruit){
        Fruit newFruit = fruitService.updateOrInsertFruit(fruit);
        return ResponseEntity.ok(newFruit);
    }
    @PostMapping("/{name}")
    public ResponseEntity<List<Fruit>> getFruitsLikeName(@PathVariable String name){
        List<Fruit> allFruitsLikeName = fruitService.findFruitsByLikeName(name);
        return ResponseEntity.ok(allFruitsLikeName);
    }
    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id){
        fruitService.deleteFruit(id);
    }
}
