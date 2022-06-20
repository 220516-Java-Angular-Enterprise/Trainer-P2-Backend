package com.revature.yolp.review;

import com.revature.yolp.restaurant.Restaurant;
import com.revature.yolp.user.User;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private String id;

    @Column(name = "msg", nullable = false)
    private String msg;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Review() {
    }

    public Review(String id, String msg, int rating, User user) {
        this.id = id;
        this.msg = msg;
        this.rating = rating;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", msg='" + msg + '\'' +
                ", rating=" + rating +
                ", user=" + user +
                '}';
    }
}
