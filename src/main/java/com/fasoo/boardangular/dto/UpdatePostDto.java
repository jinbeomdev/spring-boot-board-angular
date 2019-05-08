package com.fasoo.boardangular.dto;

import com.fasoo.boardangular.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostDto {

  private String title;
  private String content;

  public Post updatePost (Post post) {
    post.setTitle(title);
    post.setContent(content);
    return post;
  }
}
