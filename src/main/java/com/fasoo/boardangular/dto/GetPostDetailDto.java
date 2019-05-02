package com.fasoo.boardangular.dto;

import com.fasoo.boardangular.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPostDetailDto {

  private String title;
  private String author;
  private String content;

  public GetPostDetailDto(Post post) {
    this.title = post.getTitle();
    this.author = post.getAuthor();
    this.content = post.getContent();
  }
}
