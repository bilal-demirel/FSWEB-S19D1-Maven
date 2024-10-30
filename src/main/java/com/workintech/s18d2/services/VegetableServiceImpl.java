package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidIdException;
import com.workintech.s18d2.exceptions.NotFoundIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements  VegetableService{
    VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository){
        this.vegetableRepository = vegetableRepository;
    }
    @Override
    public List<Vegetable> findAllVegetableDescByPrice() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllVegetableAscByPrice() {
        return vegetableRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Vegetable> findVegetablesByLikeName(String name) {
        return vegetableRepository.findByNameContaining(name);
    }

    @Override
    public Vegetable getVegetableById(Long id){
        if(id < 0){
            throw new InvalidIdException("ID cannot be smaller than 0!");
        }
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isEmpty()){
            throw new NotFoundIdException("There isn't any data with this ID!");
        }
        return vegetable.orElse(null);
    }

    @Override
    public Vegetable updateOrInsertVegetable(Vegetable vegetable){
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void deleteVegetable(Long id){
        if(id < 0){
            throw new InvalidIdException("ID cannot be smaller than 0!");
        }
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isEmpty()){
            throw new NotFoundIdException("There isn't any data with this ID!");
        }
        vegetableRepository.deleteById(id);
    }
}
