package com.sofkaU.relational.service;

import com.sofkaU.relational.entity.Comment;
import com.sofkaU.relational.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    Post createPost(Post post);

    Post createComment(Comment comment);

    void deleteComment(Comment comment);

    void deletePost(Post comment);

    List<Post> findAllPosts();

}
