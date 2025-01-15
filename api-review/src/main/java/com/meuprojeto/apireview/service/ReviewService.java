package com.meuprojeto.apireview.service;

import com.meuprojeto.apireview.model.ApiEnt;
import com.meuprojeto.apireview.model.Review;
import com.meuprojeto.apireview.model.User;
import com.meuprojeto.apireview.repository.ApiEntityRepository;
import com.meuprojeto.apireview.repository.ReviewRepository;
import com.meuprojeto.apireview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApiEntityRepository apiEntityRepository;

    public Review createReview(Long userId, Long apiId, Review review) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ApiEnt apiEntity = apiEntityRepository.findById(apiId).orElseThrow(() -> new RuntimeException("API not found"));

        review.setUser(user);
        review.setApi(apiEntity);
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByApi(Long apiId) {
        return reviewRepository.findByApiId(apiId);
    }

    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    // etc...
}
