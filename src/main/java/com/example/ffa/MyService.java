package com.example.ffa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.TFruit;
import model.TFruitShop;
import model.TPrice;
import model.TUser;

@Service
public class MyService {
 
    @Autowired
    private Dao dao;

    public List<TFruit> getFruit() {
        return dao.getFruit();
    }
    public List<TFruitShop> getFruitShop() {
        return dao.getFruitShop();
    }
    public List<TPrice> getPrice() {
        return dao.getPrice();
    }
    public List<TUser> getUser() {
        return dao.getUser();
    }
    public List<Object[]> getPriceWithFruitAndShopName() {
        return dao.getPriceWithFruitAndShopName();
    }

    
    public void addFruit(TFruit fruit) {
        dao.addFruit(fruit);
    }
    public void addFruitShop(TFruitShop fruitShop) {
        dao.addFruitShop(fruitShop);
    }  
    public void addPrice(TPrice price) {
        dao.addPrice(price);
    }
    public void addUser(TUser user) {
        dao.addUser(user);
    }

    
    public void updateFruit(TFruit fruit) {
        dao.updateFruit(fruit);
    }
    public void updateFruitShop(TFruitShop fruitShop) {
        dao.updateFruitShop(fruitShop);
    } 
    public void updatePrice(TPrice price) {
        dao.updatePrice(price);
    }
    public void updateUser(TUser user) {
        dao.updateUser(user);
    }

    
    public void deleteFruit(Long fruitId) {
        dao.deleteFruit(fruitId);
    }
    public void deleteFruitShop(Long fruitShopId) {
        dao.deleteFruitShop(fruitShopId);
    }
    public void deletePrice(Long priceId) {
        dao.deleteUser(priceId);
    }
    public void deleteUser(Long userId) {
        dao.deleteUser(userId);
    }
    
    // OTHERS
    public List<TUser> obtenerTodosLosUsersBaja() {
        return dao.obtenerTodosLosUsersBaja();
    }
    
    // LOGIN
    public TUser searchUserByNameAndPassword(String username, String password) {
        return dao.searchUserByNameAndPassword(username, password);
    }
    
    //SEARCH FRUITS BY NAME
    public List<Object[]> searchFruitsByName(String name) {
        return dao.searchFruitsByName(name);
    }
    
    // SEARCH FRUITSHOPS BY NAME
    public List<TFruitShop> searchFruitShopsByName(String name) {
        return dao.searchFruitShopsByName(name);
    }
    
}

