package com.sparta.spring_skillful_week_assignment.repository;

import com.sparta.spring_skillful_week_assignment.entity.Comment;
import com.sparta.spring_skillful_week_assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByIdAndUser_Id(Long id, Long userId);


    List<Comment> findAllByPost_IdOrderByCreatedAtDesc(Long postId);

}
