package com.meuprojeto.apireview.controller;

import com.meuprojeto.apireview.model.Review;
import com.meuprojeto.apireview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/user/{userId}/api/{apiId}")
    public ResponseEntity<Review> createReview(@PathVariable Long userId,
                                               @PathVariable Long apiId,
                                               @RequestBody Review review) {
        Review savedReview = reviewService.createReview(userId, apiId, review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/api/{apiId}")
    public ResponseEntity<List<Review>> getReviewsByApi(@PathVariable Long apiId) {
        return ResponseEntity.ok(reviewService.getReviewsByApi(apiId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userId));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
