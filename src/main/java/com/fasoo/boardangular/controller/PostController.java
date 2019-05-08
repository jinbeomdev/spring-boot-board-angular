package com.fasoo.boardangular.controller;

import com.fasoo.boardangular.dto.GetPostDetailDto;
import com.fasoo.boardangular.dto.GetPostsDto;
import com.fasoo.boardangular.dto.UpdatePostDto;
import com.fasoo.boardangular.dto.WritePostDto;
import com.fasoo.boardangular.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<GetPostsDto> getPost(HttpServletRequest request) {
        return postService.getPosts();
    }

    @GetMapping("/post/{postId}")
    public GetPostDetailDto getPostDeail(@PathVariable(name = "postId") Long postId)
      throws ChangeSetPersister.NotFoundException {
        return postService.getPostDetail(postId);
    }

    @PostMapping("/writePost")
    public void writePost(@RequestBody WritePostDto writePostDto) {
        postService.writePost(writePostDto);
    }

    @PutMapping("/post/{postId}")
    public void updatePost(@PathVariable(name = "postId") Long postId, @RequestBody UpdatePostDto updatePostDto) {
        postService.updatePost(postId, updatePostDto);
    }
}