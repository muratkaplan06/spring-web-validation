package com.yteintern.springweb;

import com.yteintern.springweb.data.Comment;
import com.yteintern.springweb.data.Post;
import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.Objects;

public class RestTemplateTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    RestTemplate restTemplate = new RestTemplate();
    //bu url den bütün postları getir
    @Test
    void getPosts() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> responseEntity = restTemplate.exchange(requestEntity, Post[].class);
        System.out.println(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).toList());
    }
  //post id si 2 olan postu getir
    @Test
    void singlePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post> responseEntity = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(responseEntity.getBody());
    }
    //body içindeki değerleri post et
    @Test
    void addPost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Post> requestEntity =
                RequestEntity.post(uri).body(new Post(7L,null,"asdf","aas"));
        ResponseEntity<Post> responseEntity = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(responseEntity.getBody());

    }
    // userId 2 olan postları getir
    @Test
    void getPostsByUserId(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId",2)
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> responseEntity = restTemplate.exchange(requestEntity, Post[].class);
        System.out.println(Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).toList());
    }
    //id si 5 olan commenti güncelle
    @Test
    void updateComment(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments","5")
                .build()
                .toUri();

        RequestEntity<Comment> requestEntity =
                RequestEntity.put(uri).body(new Comment(null,null,"asdf","aas","asdf"));
        ResponseEntity<Comment> responseEntity = restTemplate.exchange(requestEntity, Comment.class);
        System.out.println(responseEntity.getBody());
    }
    //id si 1 olan postu sil
    @Test
    void deletePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","1")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.delete(uri).build();
        ResponseEntity<Void> responseEntity = restTemplate.exchange(requestEntity, Void.class);
        System.out.println(responseEntity.getStatusCode());
    }

}
