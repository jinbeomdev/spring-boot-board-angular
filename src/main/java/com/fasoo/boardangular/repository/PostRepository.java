package com.fasoo.boardangular.repository;

import com.fasoo.boardangular.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("SELECT p " +
    "FROM Post p " +
    "ORDER BY p.id DESC")
  Stream<Post> findAllDesc();
}
