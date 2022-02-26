

package com.example.demo.post;

import com.example.demo.board.BoardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @PostMapping
    public void createPost(@PathVariable("boardId") int boardId,@RequestBody PostDto postDto) {
        logger.info("post savd");
        this.postRepository.save(boardId,postDto);
    }

    @GetMapping
    public List<PostDto> readPostAll(
            @PathVariable("boardId") int boardId
    ) {
        if (this.postRepository.findAll(boardId).isEmpty()) {
            logger.info("not find");
        }
        return this.postRepository.findAll(boardId);    }


    // GET
    @GetMapping("{postId}")
    public void readPost(@PathVariable("boardId") int boardId, @PathVariable("postId") int postId) {
        return ;
    }

    @PutMapping("{postId}")
    public void updatePost(@PathVariable("boardId") int boardId, @PathVariable("postId") int postId, @RequestBody PostDto postDto) {
        return ;
    }

    @DeleteMapping({"{postId}"})
    public void deletePost(@PathVariable("boardId") int boardId, @PathVariable("postId") int postId, @RequestParam ("password") String password) {
        return ;
    }
}
