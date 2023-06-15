package com.example.reddit.WeekendProject.service;

public interface RedditAuthService {

    String getAuthToken();

    String getPosts(String user);

    String post(String subreddit, String title, String content, String accessToken);

}
