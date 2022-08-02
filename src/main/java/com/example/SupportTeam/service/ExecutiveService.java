package com.example.SupportTeam.service;

import com.example.SupportTeam.dto.CommentsDTO;
import com.example.SupportTeam.entity.Comments;
import com.example.SupportTeam.entity.Issue;
import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.repository.CommentsRepository;
import com.example.SupportTeam.repository.IssueRepository;
import com.example.SupportTeam.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutiveService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    public void createNewComment(CommentsDTO commentsDTO) throws Exception {
        Comments comments=new Comments();
        comments.setText(commentsDTO.getText());
        Optional<UsersDetails> optionalUsersDetails=userDetailsRepository.findById(commentsDTO.getUserId());
        if(optionalUsersDetails.isEmpty()){
            throw new Exception("User is not present");
        }
        comments.setUser(optionalUsersDetails.get());

        Optional<Issue> optionalIssue=issueRepository.findById(commentsDTO.getIssueId());
        if(optionalIssue.isEmpty()){
            throw new Exception("Issue is not present");
        }
        comments.setIssue(optionalIssue.get());
        commentsRepository.save(comments);
    }

    public List<Comments> getAllComments(Long userId, Long issueId) throws Exception {
        System.out.println("Very Long Character issue1");
        Optional<Issue> optionalissue=issueRepository.findById(issueId);
        if(optionalissue.isEmpty()){
            throw new Exception("Invalid issue request");
        }
        System.out.println("Very Long Character issue2");
        if(optionalissue.get().getAssignedTo().getId()!=userId){
            throw new Exception("Invalid User request");
        }
        System.out.println("Very Long Character issue5");
        List<Comments> optionalComments = commentsRepository.findByIssueId(issueId);
        if(optionalComments.isEmpty()){
            throw new Exception("No comments");
        }
        //allcomments assignment removed ; additional .stream().toList() from output
        return optionalComments;
    }
}

