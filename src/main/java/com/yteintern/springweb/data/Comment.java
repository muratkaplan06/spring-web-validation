package com.yteintern.springweb.data;

public record Comment(Long postId, Long Id, String name, String email, String body) {
}
