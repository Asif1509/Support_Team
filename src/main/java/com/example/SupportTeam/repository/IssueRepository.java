package com.example.SupportTeam.repository;

import com.example.SupportTeam.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IssueRepository
        extends JpaRepository<Issue, Long> {

   //@Query("select * from Issue where Issue.assignedTo is Null")
   List<Issue> findByAssignedToIsNull();

   List<Issue> findByAssignedToIsNotNull();
}
























/*
    Optional<Issue> findIssueById(Long id);
    Optional<Issue>findStudentByEmail(String email);
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private UsersDetails assignedTo;*/




//  @Query("select * from Issue where Issue.UsersDetails.assigned_to=UNASSIGNED")
//@Query("SELECT i FROM Employee e WHERE e.name = :name AND e.age = :empAge")
