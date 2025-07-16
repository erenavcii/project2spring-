package com.erenavci.project2spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // 'user' SQL'de rezerve kelime, o yüzden çoğul kullanıyoruz
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // kullanıcı adı benzersiz olmalı

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email; // email de benzersiz olmalı
}
