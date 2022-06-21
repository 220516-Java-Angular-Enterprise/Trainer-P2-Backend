package com.revature.yolp.restaurant;

import com.revature.yolp.common.annotations.Inject;
import com.revature.yolp.restaurant.dtos.requests.NewRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {
    @Inject
    private final RestaurantRepository restoRepo;

    @Inject
    @Autowired
    public RestaurantService(RestaurantRepository restoRepo) {
        this.restoRepo = restoRepo;
    }

    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restoRepo.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String id) {
        return restoRepo.findById(id);
    }

    public String createNewResto(NewRestaurantRequest request) {
        Restaurant restaurant = new Restaurant(UUID.randomUUID().toString(), request);
        restoRepo.save(restaurant);
        return restaurant.getId();
    }
}
