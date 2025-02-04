package spring.app.modules.comments.event.service;

import spring.app.modules.comments.event.dto.EventCommentCreateDto;
import spring.app.modules.comments.event.dto.EventCommentDto;

import java.util.List;

public interface EventCommentService {
    int createEventComment(EventCommentCreateDto commentDto);

    int updateEventComment(Long id, EventCommentCreateDto eventComment);

    EventCommentDto getEventCommentById(Long id);

    void deleteById(Long id);

    List<EventCommentDto> getAllEventComments();
}
