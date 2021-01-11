package com.Zipcode.Rocks.Repositories;

import com.Zipcode.Rocks.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentByCommentId(Long commentId);

    List<Comment> findCommentsByVideoId(Long videoId);
}
