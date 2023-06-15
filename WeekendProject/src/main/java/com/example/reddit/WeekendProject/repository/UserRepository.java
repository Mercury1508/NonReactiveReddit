package com.example.reddit.WeekendProject.repository;

import com.example.reddit.WeekendProject.model.UserPosts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserPosts,Integer> {

    List<UserPosts> findByAuthor(String name);

    void deleteByAuthor(String name);

    List<UserPosts> findByBodyContainingIgnoreCase(String keyword);

}
