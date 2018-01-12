package com.example.demo2.Repository;

import com.example.demo2.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer>{
    public List<User> findById(int id);
}
