package com.example.demo.board;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryInMemory implements BoardRepository {
    private int index = 0;
    private final List<BoardDto> boardList = new ArrayList();

    @Override
    public int save(BoardDto boardDto) {
        index++;
        boardDto.setId(index);
        boardList.add(boardDto);
        return index;
    }

    @Override
    public List<BoardDto> findAll() {
        return this.boardList;
    }

    @Override
    public BoardDto findById(int id) {
        return this.boardList.get(id-1);
    }

    @Override
    public boolean update(int id, BoardDto boardDto) {
        if (boardDto.getName() != null) {
            this.boardList.get(id-1).setName(boardDto.getName());
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.boardList.remove(id-1);
        return true;
    }
}