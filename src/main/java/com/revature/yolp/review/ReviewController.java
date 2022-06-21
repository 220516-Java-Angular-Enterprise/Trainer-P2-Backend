package com.revature.yolp.review;

import com.revature.yolp.common.annotations.Inject;
import com.revature.yolp.review.dtos.requests.NewReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Inject
    ReviewService reviewService;

    @Inject
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createNewReview(@RequestBody NewReviewRequest request) {
        return reviewService.createNewReview(request);
    }
}
