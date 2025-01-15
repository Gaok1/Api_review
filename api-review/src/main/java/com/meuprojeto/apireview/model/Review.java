package com.meuprojeto.apireview.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;         // ex.: 0 a 5
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Autor da review

    @ManyToOne
    @JoinColumn(name = "api_id")
    private ApiEnt api; // Qual API está sendo avaliada

    //getter
    public Integer getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public User getUser() {
        return user;
    }
    public ApiEnt getApi() {
        return api;
    }

    //setter
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setApi(ApiEnt api) {
        this.api = api;
    }
}
