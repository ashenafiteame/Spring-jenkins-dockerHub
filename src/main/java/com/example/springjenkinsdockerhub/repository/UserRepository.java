package com.example.springjenkinsdockerhub.repository;

import com.example.springjenkinsdockerhub.domain.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
