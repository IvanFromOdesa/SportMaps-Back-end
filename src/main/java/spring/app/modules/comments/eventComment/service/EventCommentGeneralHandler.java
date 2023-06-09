package spring.app.modules.comments.eventComment.service;

import spring.app.modules.comments.eventComment.domain.EventComment;
import spring.app.modules.comments.eventComment.dto.EventCommentDto;

import java.util.List;
import java.util.stream.Collectors;

public interface EventCommentGeneralHandler {
    default EventCommentDto allInfoDto(EventComment eventComment) {
        return EventCommentDto.builder()
                .id(eventComment.getId())
                .createdDate(String.valueOf(eventComment.getCreatedDate()))
                .text(eventComment.getText())
                .emailUser(eventComment.getCreatedBy().getEmail())
                .idEvent(eventComment.getEvent().getIdEvent())
                .build();
    }

    default List<EventCommentDto> listToDto(List<EventComment> eventCommentList) {
        return eventCommentList.stream().map(this::allInfoDto).collect(Collectors.toList());
    }
}
