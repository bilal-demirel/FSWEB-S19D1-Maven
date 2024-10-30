package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAllVegetableDescByPrice();
    List<Vegetable> findAllVegetableAscByPrice();
    List<Vegetable> findVegetablesByLikeName(String name);
    Vegetable getVegetableById(Long id);
    Vegetable updateOrInsertVegetable(Vegetable vegetable);
    void deleteVegetable(Long id);
}
