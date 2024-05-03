package com.example.ffa;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import model.TFruit;
import model.TFruitShop;
import model.TPrice;
import model.TUser;
 
@Repository
public class Dao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<TFruit> getFruit() {
        return entityManager.createQuery("SELECT tf FROM TFruit tf", TFruit.class).getResultList();
    }
    public List<TFruitShop> getFruitShop() {
        return entityManager.createQuery("SELECT tfs FROM TFruitShop tfs", TFruitShop.class).getResultList();
    }
    public List<TPrice> getPrice() {
        return entityManager.createQuery("SELECT tp FROM TPrice tp", TPrice.class).getResultList();
    }
    public List<TUser> getUser() {
        return entityManager.createQuery("SELECT tu FROM TUser tu", TUser.class).getResultList();
    }
    
    @Transactional
    public void addFruit(TFruit fruit) {
        entityManager.persist(fruit);
    }
    @Transactional
    public void addFruitShop(TFruitShop fruitShop) {
        entityManager.persist(fruitShop);
    }
    @Transactional
    public void addPrice(TPrice price) {
        entityManager.persist(price);
    }
    @Transactional
    public void addUser(TUser user) {
        entityManager.persist(user);
    }
    
    
    @Transactional
    public void updateFruit(TFruit fruit) {
        entityManager.merge(fruit);
    }
    @Transactional
    public void updateFruitShop(TFruitShop fruitShop) {
        entityManager.merge(fruitShop);
    }
    @Transactional
    public void updatePrice(TPrice price) {
        entityManager.merge(price);
    }
    @Transactional
    public void updateUser(TUser user) {
        entityManager.merge(user);
    }

    
    @Transactional
    public void deleteFruit(@Param("fruitId") Long fruitId) {
        TFruit fruit = entityManager.find(TFruit.class, fruitId);
        if (fruit != null) {
            entityManager.remove(fruit);
        }
    }
    @Transactional
    public void deleteFruitShop(@Param("fruitShopId") Long fruitShopId) {
        TFruitShop fruitShop = entityManager.find(TFruitShop.class, fruitShopId);
        if (fruitShop != null) {
            entityManager.remove(fruitShop);
        }
    }
    @Transactional
    public void deletePrice(@Param("userId") Long priceId) {
        TPrice price = entityManager.find(TPrice.class, priceId);
        if (price != null) {
            entityManager.remove(price);
        }
    }
    @Transactional
    public void deleteUser(@Param("userId") Long userId) {
        TUser user = entityManager.find(TUser.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }
     

    // OTHERS
    public List<TUser> obtenerTodosLosUsersBaja() {
        return entityManager.createQuery("SELECT u FROM Users u WHERE u.baja = true", TUser.class).getResultList();
    }
    public TUser searchUserByNameAndPassword(String username, String contraseña) {
        try {
            return entityManager.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password", TUser.class)
                    .setParameter("username", username)
                    .setParameter("password", contraseña)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
