package com.revature.yolp.restaurant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
    Restaurant findRestaurantById(String id);
}
