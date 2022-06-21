package com.revature.yolp.review;

import com.revature.yolp.common.annotations.Inject;
import com.revature.yolp.restaurant.Restaurant;
import com.revature.yolp.restaurant.RestaurantRepository;
import com.revature.yolp.review.dtos.requests.NewReviewRequest;
import com.revature.yolp.user.User;
import com.revature.yolp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {
    @Inject
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final RestaurantRepository restoRepo;

    @Inject
    @Autowired
    public ReviewService(ReviewRepository reviewRepo, UserRepository userRepo, RestaurantRepository restoRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.restoRepo = restoRepo;
    }

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepo.findAll();
    }

    public String createNewReview(NewReviewRequest request) {
        Review review = new Review(UUID.randomUUID().toString(), request);
        review.setUser(userRepo.findUserById(request.getUser_id()));
        review.setRestaurant(restoRepo.findRestaurantById(request.getRestaurant_id()));
        reviewRepo.save(review);
        return review.getId();
    }
}
