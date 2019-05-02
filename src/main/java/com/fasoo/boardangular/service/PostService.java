package com.fasoo.boardangular.service;

import com.fasoo.boardangular.dto.GetPostDetailDto;
import com.fasoo.boardangular.dto.GetPostsDto;
import com.fasoo.boardangular.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<GetPostsDto> getPosts() {
        return postRepository.findAll()
          .stream().map(GetPostsDto::new)
          .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GetPostDetailDto getPostDetail(Long postId)
      throws ChangeSetPersister.NotFoundException {
        return postRepository.findById(postId)
          .map(GetPostDetailDto::new)
          .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
