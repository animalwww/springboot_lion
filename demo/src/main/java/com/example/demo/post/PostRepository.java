
package com.example.demo.post;

import com.example.demo.post.PostDto;
import java.util.List;

public interface PostRepository {
    PostDto save(int boardId, PostDto postDto);

    PostDto findById(int boardId, int postId);

    List<PostDto> findAll(int boardId);


    boolean update(int boardId,int postId, PostDto postDto);

    boolean delete(int boardId,int postId,String password);
}
