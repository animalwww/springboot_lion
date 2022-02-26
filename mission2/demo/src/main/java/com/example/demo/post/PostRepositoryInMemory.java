package com.example.demo.post;

import com.example.demo.board.BoardDto;
import com.example.demo.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryInMemory implements PostRepository{
    private int index = 0;
    private final List<PostDto> postList = new ArrayList();

    //몰랐던부분
    private final BoardRepository boardRepository;

    public PostRepositoryInMemory(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public PostDto save(int boardId, PostDto postDto) {
        BoardDto boardDto = this.boardRepository.findById(boardId);
        if(boardDto == null){
            return null;
        }
        postDto.setBoardId(boardId);
        index++;
        postDto.setId(index);
        postList.add(postDto);
        return postDto;
    }

    @Override
    public PostDto findById(int boardId, int postId) {
        int i = 1;
        while(this.postList.get(i) != null) {
            this.postList.get(i);
            i++;
        }
        return this.postList.get(boardId+postId-1);
    }

    @Override
    public List<PostDto> findAll(int boardId) {
        int i = 0;
        if (boardRepository.findById(boardId) != null) {
            ArrayList<PostDto> postDtos = new ArrayList<>();
            while(postList.get(i) !=null) {
                if (this.postList.get(i).getBoardId() == boardId)
                    postDtos.add(postList.get(i));
                i++;
            }
            return postDtos;
        }
        return null;
    }

    @Override
    public boolean update(int boardId, int postId, PostDto postDto) {
//        if (postDto.getId() != null) {
//            this.postList.get(postId-1).setName(postDto.getName());
//        }
        return true;
    }

    @Override
    public boolean delete(int boardId, int postId, String password) {
        this.postList.remove(postId-1);
        return true;
    }
}
