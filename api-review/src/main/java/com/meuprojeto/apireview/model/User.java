package com.meuprojeto.apireview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // "user" é keyword em alguns bancos
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    // se quiser roles (enum?), ou algo do tipo
}
