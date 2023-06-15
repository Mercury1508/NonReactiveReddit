package com.example.reddit.WeekendProject.service;

import com.example.reddit.WeekendProject.model.Children;
import com.example.reddit.WeekendProject.model.Data1;
import com.example.reddit.WeekendProject.model.Overall;
import com.example.reddit.WeekendProject.model.UserPosts;
import com.example.reddit.WeekendProject.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RedditCRUDImplementation implements RedditCRUD{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedditAuthService redditAuthService;


    @Override
    public String getPostsBySubreddit(String subreddit) throws JsonProcessingException {
        String response = redditAuthService.getPosts(subreddit);
        ObjectMapper objectMapper = new ObjectMapper();
        Overall responseObj = objectMapper.readValue(response, Overall.class);
        Data1 d1=responseObj.getData();
        List<Children> c1=d1.getChildren();
        for(Children c:c1) {
            UserPosts uc = c.getData();
            Date date = new Date ();
            date.setTime((long)uc.getCreated()*1000);
            UserPosts uc2 = new UserPosts(uc.getAuthor(),uc.getLink_title(),uc.getBody(),uc.getCreated());
            uc2.setDate_of_comment(date);
            userRepository.save(uc2);
        }
        return response;
    }

    @Override
    public List<UserPosts> getPostsByName(String name) {
        return this.userRepository.findByAuthor(name);
    }

    @Override
    public void deletePostsByName(String name) {
        this.userRepository.deleteByAuthor(name);
    }

    @Override
    public List<UserPosts> getPostsByKeyword(String word) {
        return this.userRepository.findByBodyContainingIgnoreCase(word);
    }

    @Override
    public List<UserPosts> getSortedPosts() {
        Sort sort = Sort.by(Sort.Direction.DESC, "date_of_comment");
        return this.userRepository.findAll(sort);
    }

    @Override
    public String createRedditPosts() {
        try {
            String accessToken = redditAuthService.getAuthToken();
            redditAuthService.post("test","LoadTesting","oops", accessToken);
            String res = getPostsBySubreddit("test");
            System.out.println(res);
            return "Post created successfully.";
        } catch (Exception e) {
            return "Failed to create post.";
        }
    }


}
