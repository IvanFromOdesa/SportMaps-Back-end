package spring.app.modules.comments.news.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.app.modules.comments.news.dto.NewsCommentCreateDto;
import spring.app.modules.comments.news.dto.NewsCommentDto;
import spring.app.modules.comments.news.service.NewsCommentService;

import java.util.List;

@RestController
@RequestMapping("/sport-maps/v1/news-comments")
@AllArgsConstructor
public class NewsCommentController {
    private final NewsCommentService commentService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public int createComment(@Valid @RequestBody NewsCommentCreateDto requestToSave) {
        return commentService.createNewsComment(requestToSave);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsCommentDto> getAllNewsComments() {
        return commentService.getAllNewsComments();
    }

    @GetMapping("/byId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsCommentDto getNewsCommentById(@PathVariable("id") Long id) {
        return commentService.getNewsCommentById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public int updateNewsCommentById(@Valid @PathVariable("id") Long id, @RequestBody NewsCommentCreateDto requestToSave) {
        return commentService.updateNewsComment(id, requestToSave);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNewsCommentById(@PathVariable("id") Long id) {
        commentService.deleteById(id);
    }
}
