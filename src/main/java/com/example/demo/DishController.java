package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final List<Dish> dishes = new ArrayList<>();
    private int nextId = 1;

    
    @PostMapping
    public ResponseEntity<Dish> createDish(
            @RequestBody Dish dish) {

        dish.id = nextId++;
        dishes.add(dish);

        return ResponseEntity.status(201).body(dish);
    }

   
    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(dishes);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(
            @PathVariable int id) {

        for (Dish dish : dishes) {
            if (dish.id == id) {
                return ResponseEntity.ok(dish);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(
            @PathVariable int id) {

        boolean removed =
                dishes.removeIf(dish -> dish.id == id);

        if (removed) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
    
   
    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(
            @PathVariable int id,
            @RequestBody Dish updatedDish) {

        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).id == id) {
                updatedDish.id = id;
                dishes.set(i, updatedDish);
                return ResponseEntity.ok(updatedDish);
            }
        }

        return ResponseEntity.notFound().build();
    }

   
    @PatchMapping("/{id}")
    public ResponseEntity<Dish> patchDish(
            @PathVariable int id,
            @RequestBody Map<String, Object> updates) {

        for (Dish dish : dishes) {
            if (dish.id == id) {

                if (updates.containsKey("dishName")) {
                    dish.dishName =
                        (String) updates.get("dishName");
                }

                if (updates.containsKey("restaurant")) {
                    dish.restaurant =
                        (String) updates.get("restaurant");
                }

                if (updates.containsKey("category")) {
                    dish.category =
                        (String) updates.get("category");
                }

                if (updates.containsKey("price")) {
                    dish.price =
                        ((Number) updates.get("price"))
                            .doubleValue();
                }

                if (updates.containsKey("calories")) {
                    dish.calories =
                        ((Number) updates.get("calories"))
                            .intValue();
                }

                if (updates.containsKey("isVegetarian")) {
                    dish.isVegetarian =
                        (Boolean) updates.get("isVegetarian");
                }

                return ResponseEntity.ok(dish);
            }
        }

        return ResponseEntity.notFound().build();
    }

}


