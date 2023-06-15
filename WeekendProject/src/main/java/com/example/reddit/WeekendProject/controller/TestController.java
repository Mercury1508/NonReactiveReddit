package com.example.reddit.WeekendProject.controller;

import com.example.reddit.WeekendProject.model.UserPosts;
import com.example.reddit.WeekendProject.repository.UserRepository;
import com.example.reddit.WeekendProject.service.RedditAuthService;
import com.example.reddit.WeekendProject.service.RedditCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class TestController {
    private RedditCRUD redditCRUD;

    public TestController(RedditCRUD redditCRUD) {
        this.redditCRUD = redditCRUD;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Working!!!";
    }

    @GetMapping("/test/{subreddit}")
    public String getPostsBySubreddit(@PathVariable String subreddit) throws JsonProcessingException {
        return redditCRUD.getPostsBySubreddit(subreddit);
    }

    @GetMapping("get/{name}")
    public List<UserPosts> getPostsByName(@PathVariable String name){
        return redditCRUD.getPostsByName(name);
    }

    @DeleteMapping("delete/{name}")
    public void deletePostsByName(@PathVariable String name){
        redditCRUD.deletePostsByName(name);
    }

    @GetMapping("keyword/{word}")
    public List<UserPosts> getPostsByKeyword(@PathVariable String word){
        return redditCRUD.getPostsByKeyword(word);
    }

    @GetMapping("/sort")
    public List<UserPosts> getSortedPosts(){
        return redditCRUD.getSortedPosts();
    }

    @GetMapping("/reddit/post")
    public String createRedditPost() {
        return redditCRUD.createRedditPosts();
    }
}
