package com.sofkaU.relational.service;

import com.sofkaU.relational.entity.Comment;
import com.sofkaU.relational.entity.Post;
import com.sofkaU.relational.repository.CommentRepository;
import com.sofkaU.relational.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post createComment(Comment comment) {
        Post post=postRepository.findById(comment.getFkpostId()).get();
        post.addcomment(comment);
        commentRepository.save(comment);
        return postRepository.save(post);

    }

    @Override
    public void deleteComment(Comment comment) {

        commentRepository.deleteById(comment.getId());
    }

    @Override
    public void deletePost(Post post) {
        postRepository.deleteById(post.getId());

//        Post postToBeDeleted = postRepository.findById(post.getId()).get();
//        if(postToBeDeleted.getComments().size() >=0){
//            postToBeDeleted.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
//        }
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
