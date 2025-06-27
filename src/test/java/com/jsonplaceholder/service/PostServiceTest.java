package com.jsonplaceholder.service;

import com.jsonplaceholder.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Set the apiUrl field manually since @Value is not processed in unit tests
        postService = new PostService(restTemplate);
        // Reflection to set private field apiUrl
        try {
            java.lang.reflect.Field field = PostService.class.getDeclaredField("apiUrl");
            field.setAccessible(true);
            field.set(postService, "http://fake.api/posts");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void fetchAllFromExternalApi_returnsPosts() {
        Post post1 = new Post();
        post1.setId(1);
        post1.setUserId(1);
        post1.setTitle("Title 1");
        post1.setBody("Body 1");
        Post post2 = new Post();
        post2.setId(2);
        post2.setUserId(2);
        post2.setTitle("Title 2");
        post2.setBody("Body 2");
        Post[] posts = new Post[]{post1, post2};
        when(restTemplate.getForObject("http://fake.api/posts", Post[].class)).thenReturn(posts);

        List<Post> result = postService.fetchAllFromExternalApi();
        assertEquals(2, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
    }

    @Test
    void saveLocally_and_getAllLocalPosts() {
        Post post = new Post();
        post.setId(10);
        post.setUserId(5);
        post.setTitle("Test Title");
        post.setBody("Test Body");
        postService.saveLocally(post);
        List<Post> localPosts = postService.getAllLocalPosts();
        assertEquals(1, localPosts.size());
        assertEquals("Test Title", localPosts.get(0).getTitle());
    }
}
