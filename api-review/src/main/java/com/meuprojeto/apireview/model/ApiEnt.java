package com.meuprojeto.apireview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "api_entities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String baseUrl;

    //getter
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getBaseUrl() {
        return baseUrl;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
}
