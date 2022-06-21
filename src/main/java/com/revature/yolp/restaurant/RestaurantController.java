package com.revature.yolp.restaurant;

import com.revature.yolp.common.annotations.Inject;
import com.revature.yolp.restaurant.dtos.requests.GetRestaurantByIdRequest;
import com.revature.yolp.restaurant.dtos.requests.NewRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Inject
    private final RestaurantService restoService;

    @Inject
    @Autowired
    public RestaurantController(RestaurantService restoService) {
        this.restoService = restoService;
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Restaurant> getAllRestaurants() {
        return restoService.getAllRestaurants();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Restaurant> getRestaurantById(@PathVariable String id) {
        return restoService.getRestaurantById(id);
    }

    @CrossOrigin
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createNewResto(@RequestBody NewRestaurantRequest request) {
        return restoService.createNewResto(request);
    }
}
