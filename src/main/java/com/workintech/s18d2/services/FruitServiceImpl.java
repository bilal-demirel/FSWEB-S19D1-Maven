package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidIdException;
import com.workintech.s18d2.exceptions.NotFoundIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements  FruitService{
    FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }
    @Override
    public List<Fruit> findAllFruitDescByPrice() {
        return fruitRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Fruit> findAllFruitAscByPrice() {
        return fruitRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Fruit> findFruitsByLikeName(String name) {
        return fruitRepository.findByNameContaining(name);
    }

    @Override
    public Fruit getFruitById(Long id){
        if(id < 0){
            throw new InvalidIdException("ID cannot be smaller than 0!");
        }
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isEmpty()){
            throw new NotFoundIdException("There isn't any data with this ID!");
        }
        return fruit.orElse(null);
    }

    @Override
    public Fruit updateOrInsertFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(Long id){
        if(id < 0){
            throw new InvalidIdException("ID cannot be smaller than 0!");
        }
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isEmpty()){
            throw new NotFoundIdException("There isn't any data with this ID!");
        }
        fruitRepository.deleteById(id);
    }
}
