package com.fasoo.boardangular.dto;

import com.fasoo.boardangular.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
@ToString
public class GetPostsDto {
  private Long id;
  private String title;
  private String author;
  private String modifiedDate;

  public GetPostsDto(Post post) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.author = post.getAuthor();
    this.modifiedDate = toStringDate(post.getModifiedDate());
  }

  private String toStringDate(LocalDateTime localDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return Optional.ofNullable(localDateTime)
      .map(formatter::format)
      .orElse("");
  }
}
