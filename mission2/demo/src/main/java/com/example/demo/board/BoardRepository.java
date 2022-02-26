package com.example.demo.board;


import java.util.List;

public interface BoardRepository {
    int save(BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto findById(int id);

    boolean update(int id, BoardDto boardDto);

    boolean delete(int id);
}
