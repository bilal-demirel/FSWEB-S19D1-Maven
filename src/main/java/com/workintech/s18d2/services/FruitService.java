package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAllFruitDescByPrice();
    List<Fruit> findAllFruitAscByPrice();
    List<Fruit> findFruitsByLikeName(String name);
    Fruit getFruitById(Long id);
    Fruit updateOrInsertFruit(Fruit fruit);
    void deleteFruit(Long id);
}
