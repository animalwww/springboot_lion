package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardRepository boardRepository;


    public BoardController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @PostMapping
    public void createBoard(@RequestBody BoardDto boardDto) {
        logger.info("savd");
        this.boardRepository.save(boardDto);
    }

    @GetMapping
    public List<BoardDto> readBoardAll() {
        if (this.boardRepository.findAll().isEmpty()) {
            logger.info("not find");
        }
        return this.boardRepository.findAll();
    }


    // GET /post?id=0
    @GetMapping({"{id}"})
    public BoardDto readBoard(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.boardRepository.findById(id);
    }

    @PutMapping({"{id}"})
    public void updateBoard(@PathVariable("id") int id, @RequestBody BoardDto boardDto) {
        this.boardRepository.update(id,boardDto);
    }

    @DeleteMapping({"{id}"})
    public void deleteBoard(@PathVariable("id") int id) {

        this.boardRepository.delete(id);
    }
}
