package com.example.fullstacktest.users.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="app_users")
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String role;

}
