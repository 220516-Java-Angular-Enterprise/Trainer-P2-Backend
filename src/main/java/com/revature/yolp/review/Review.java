package com.revature.yolp.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.yolp.restaurant.Restaurant;
import com.revature.yolp.review.dtos.requests.NewReviewRequest;
import com.revature.yolp.user.User;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private String id;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "msg", nullable = false)
    private String msg;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    public Review() {
    }

    public Review(String id, NewReviewRequest request) {
        this.id = id;
        this.rating = request.getRating();
        this.msg = request.getMsg();
    }

    public Review(String id, int rating, String msg, User user, Restaurant restaurant) {
        this.id = id;
        this.rating = rating;
        this.msg = msg;
        this.user = user;
        this.restaurant = restaurant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", msg='" + msg + '\'' +
                ", user=" + user.getUsername() +
                ", restaurant=" + restaurant.getName() +
                '}';
    }
}
