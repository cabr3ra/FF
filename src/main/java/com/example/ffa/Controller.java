package com.example.ffa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.TFruit;
import model.TFruitShop;
import model.TPrice;
import model.TUser;

@RestController
public class Controller {

    @Autowired
    private MyService service;
    

    // GET
    @GetMapping(value = "Fruits", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TFruit> getFruit() {
        return service.getFruit();
    }    
    @GetMapping(value = "FruitShops", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TFruitShop> getFruitShop() {
        return service.getFruitShop();
    }    
    @GetMapping(value = "Prices", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TPrice> getPrice() {
        return service.getPrice();
    }    
    @GetMapping(value = "Users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TUser> getUser() {
        return service.getUser();
    }
    @GetMapping(value = "PricesWithName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> getPriceWithFruitAndShopName() {
        List<Object[]> priceData = service.getPriceWithFruitAndShopName();
        return ResponseEntity.ok(priceData);
    }
    @GetMapping(value = "PricesSortedAsc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> getPricesSortedByPriceAsc() {
        List<Object[]> priceData = service.getPricesSortedByPriceAsc();
        return ResponseEntity.ok(priceData);
    }
    @GetMapping(value = "PricesSortedDesc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> getPricesSortedByPriceDesc() {
        List<Object[]> priceData = service.getPricesSortedByPriceDesc();
        return ResponseEntity.ok(priceData);
    }
    
        
    
    // POST
    @PostMapping(value = "Fruits/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addFruits(@RequestBody TFruit fruit) {
        service.addFruit(fruit);
        return ResponseEntity.ok("Fruta agregada exitosamente.");
    }
    @PostMapping(value = "FruitShops/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addFruitShops(@RequestBody TFruitShop fruitShop) {
        service.addFruitShop(fruitShop);
        return ResponseEntity.ok("Fruteria agregada exitosamente.");
    }
    @PostMapping(value = "Prices/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPrices(@RequestBody TPrice price) {
        service.addPrice(price);
        return ResponseEntity.ok("Fruteria agregada exitosamente.");
    }
    @PostMapping(value = "Users/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUsers(@RequestBody TUser user) {
        service.addUser(user);
        return ResponseEntity.ok("Usuario agregado exitosamente.");
    }

    
    // PUT
    @PutMapping(value = "Fruits/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateFruits(@RequestBody TFruit fruit) {
        service.updateFruit(fruit);
        return ResponseEntity.ok("Fruta actualizada exitosamente.");
    }
    @PutMapping(value = "FruitShops/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateFruitShops(@RequestBody TFruitShop fruitShop) {
        service.updateFruitShop(fruitShop);
        return ResponseEntity.ok("Fruteria actualizada exitosamente.");
    }
    @PutMapping(value = "Prices/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePrices(@RequestBody TPrice price) {
        service.updatePrice(price);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }
    @PutMapping(value = "Users/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUsers(@RequestBody TUser user) {
        service.updateUser(user);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }


    // DELETE
    @DeleteMapping(value = "Fruits/delete/{fruitId}")
    public ResponseEntity<String> deleteFruits(@PathVariable(name = "fruitId") Long fruitId) {
        service.deleteFruit(fruitId);
        return ResponseEntity.ok("Fruta eliminada exitosamente.");
    }
    @DeleteMapping(value = "FruitShops/delete/{fruitShopId}")
    public ResponseEntity<String> deleteFruitShops(@PathVariable(name = "fruitShopId") Long fruitShopId) {
        service.deleteFruitShop(fruitShopId);
        return ResponseEntity.ok("Fruteria eliminada exitosamente.");
    } 
    @DeleteMapping(value = "Prices/delete/{priceId}")
    public ResponseEntity<String> deletePrices(@PathVariable(name = "priceId") Long priceId) {
        service.deletePrice(priceId);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
    @DeleteMapping(value = "Users/delete/{userId}")
    public ResponseEntity<String> deleteUsers(@PathVariable(name = "userId") Long userId) {
        service.deleteUser(userId);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
   
    // OTHERS
    @GetMapping(value = "Users/baja", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TUser> obtenerTodosLosUsersBaja() {
        return service.obtenerTodosLosUsersBaja();
    }
    
    // LOGIN 
    @GetMapping(value = "SearchUserLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> searchUserByNameAndPassword(@RequestParam String username, @RequestParam String password) {
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Los parámetros 'usename' y 'password' son obligatorios.");
        }
        
        TUser user = service.searchUserByNameAndPassword(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
        }
    }
    
    // SEARCH FRUITS BY NAME
    @GetMapping(value = "Prices/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Object[]> searchFruitsByName(@RequestParam("name") String name) {
        return service.searchFruitsByName(name);
    }

    
    // SEARCH FRUITSHOPS BY NAME
    @GetMapping(value = "FruitShops/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TFruitShop> searchFruitShopsByName(@RequestParam("name") String name) {
        return service.searchFruitShopsByName(name);
    }
}
