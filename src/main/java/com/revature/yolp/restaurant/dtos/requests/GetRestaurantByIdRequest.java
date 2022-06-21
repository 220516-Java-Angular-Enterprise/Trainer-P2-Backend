package com.revature.yolp.restaurant.dtos.requests;

public class GetRestaurantByIdRequest {
    private String id;

    public GetRestaurantByIdRequest() {

    }

    public GetRestaurantByIdRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetRestaurantByIdRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
