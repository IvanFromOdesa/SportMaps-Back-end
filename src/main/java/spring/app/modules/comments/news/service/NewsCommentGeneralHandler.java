package spring.app.modules.comments.news.service;

import spring.app.modules.comments.news.domain.NewsComment;
import spring.app.modules.comments.news.dto.NewsCommentDto;

import java.util.List;
import java.util.stream.Collectors;

public interface NewsCommentGeneralHandler {
    default NewsCommentDto allInfoDto(NewsComment newsComment) {
        return NewsCommentDto.builder()
                .id(newsComment.getId())
                .createdDate(String.valueOf(newsComment.getCreatedDate()))
                .text(newsComment.getText())
                .emailUser(newsComment.getCreatedBy().getEmail())
                .idNew(newsComment.getNews().getIdNew())
                .build();
    }

    default List<NewsCommentDto> listToDto(List<NewsComment> newsCommentList) {
        return newsCommentList.stream().map(this::allInfoDto).collect(Collectors.toList());
    }
}
