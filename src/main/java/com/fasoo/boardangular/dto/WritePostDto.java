package com.fasoo.boardangular.dto;

import com.fasoo.boardangular.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WritePostDto {

  private String title;
  private String author;
  private String content;

  public WritePostDto(String title, String author, String content) {
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public Post toEntity() {
    return Post.builder()
      .title(title)
      .author(author)
      .content(content)
      .build();
  }
}
