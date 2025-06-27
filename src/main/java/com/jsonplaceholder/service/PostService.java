package com.jsonplaceholder.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jsonplaceholder.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class PostService {

    private final RestTemplate restTemplate;

    @Value("${jsonplaceholder.api.uri}")
    private String apiUrl;

    private final Map<Integer, Post> localPostStorage = new HashMap<>();

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> fetchAllFromExternalApi() {
        Post[] posts = restTemplate.getForObject(apiUrl, Post[].class);
        return posts != null ? Arrays.asList(posts) : new ArrayList<>();
    }

    public Post saveLocally(Post post) {
        localPostStorage.put(post.getId(), post);
        return post;
    }

    public List<Post> getAllLocalPosts() {
        return new ArrayList<>(localPostStorage.values());
    }

}
