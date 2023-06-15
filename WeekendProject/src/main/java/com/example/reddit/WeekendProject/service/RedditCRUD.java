package com.example.reddit.WeekendProject.service;

import com.example.reddit.WeekendProject.model.UserPosts;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface RedditCRUD {

    String getPostsBySubreddit(String subreddit) throws JsonProcessingException;

    List<UserPosts> getPostsByName(String name);

    void deletePostsByName(String name);

    List<UserPosts> getPostsByKeyword(String word);

    List<UserPosts> getSortedPosts();

    String createRedditPosts();

}
