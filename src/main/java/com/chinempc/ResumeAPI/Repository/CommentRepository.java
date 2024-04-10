package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
