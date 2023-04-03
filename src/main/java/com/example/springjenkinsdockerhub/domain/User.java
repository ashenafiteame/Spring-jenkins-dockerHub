package com.example.springjenkinsdockerhub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user-table")
public class User {
    @Id
    private long userId;
    private String username;
    private String password;
    private String email;


}
