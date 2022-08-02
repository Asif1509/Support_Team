package com.example.SupportTeam.repository;

import com.example.SupportTeam.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CommentsRepository
                extends JpaRepository<Comments, Long> {
        List<Comments> findByIssueId(Long issueId);
}
