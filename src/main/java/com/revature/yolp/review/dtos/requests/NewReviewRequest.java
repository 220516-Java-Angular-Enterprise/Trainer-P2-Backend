package com.revature.yolp.review.dtos.requests;

public class NewReviewRequest {
    private int rating;
    private String msg;
    private String user_id;
    private String restaurant_id;

    public NewReviewRequest() {
    }

    public NewReviewRequest(int rating, String msg, String user_id, String restaurant_id) {
        this.rating = rating;
        this.msg = msg;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "NewReviewRequest{" +
                "rating=" + rating +
                ", msg='" + msg + '\'' +
                ", user_id='" + user_id + '\'' +
                ", restaurant_id='" + restaurant_id + '\'' +
                '}';
    }
}
