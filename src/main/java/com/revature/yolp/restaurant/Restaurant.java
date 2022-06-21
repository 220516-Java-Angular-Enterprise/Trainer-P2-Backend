package com.revature.yolp.restaurant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.yolp.restaurant.dtos.requests.NewRestaurantRequest;
import com.revature.yolp.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(
            mappedBy = "restaurant",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Review> reviews;

    public Restaurant() {
        super();
    }

    public Restaurant(String id, NewRestaurantRequest request) {
        this.id = id;
        this.name = request.getName();
        this.city = request.getCity();
        this.state = request.getState();
    }

    public Restaurant(String id, String name, String city, String state, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
