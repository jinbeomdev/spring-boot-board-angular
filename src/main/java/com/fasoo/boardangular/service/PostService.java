package com.fasoo.boardangular.service;

import com.fasoo.boardangular.dto.GetPostDetailDto;
import com.fasoo.boardangular.dto.GetPostsDto;
import com.fasoo.boardangular.dto.UpdatePostDto;
import com.fasoo.boardangular.dto.WritePostDto;
import com.fasoo.boardangular.entity.Post;
import com.fasoo.boardangular.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<GetPostsDto> getPosts() {
        return postRepository.findAllDesc()
          .map(GetPostsDto::new)
          .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GetPostDetailDto getPostDetail(Long postId)
      throws ChangeSetPersister.NotFoundException {
        return postRepository.findById(postId)
          .map(GetPostDetailDto::new)
          .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Transactional
    public void writePost(WritePostDto writePostDto) {
        log.info(writePostDto.toString());
        postRepository.save(writePostDto.toEntity());
    }

    @Transactional
    public void updatePost(Long id, UpdatePostDto updatePostDto) {
        Post post = postRepository.findById(id).get();
        postRepository.save(updatePostDto.updatePost(post));
    }
}
