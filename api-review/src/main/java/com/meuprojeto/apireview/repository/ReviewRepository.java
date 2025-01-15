package com.meuprojeto.apireview.repository;

import com.meuprojeto.apireview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByApiId(Long apiId);
    List<Review> findByUserId(Long userId);
}
