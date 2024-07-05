package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "userData")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(String password, String username){
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String username;
    private String password;

}
