package com.example.SupportTeam.entity;

import com.example.SupportTeam.enums.DataTypeEnum;

import javax.persistence.*;

    @Entity
    @Table
    public class Comments {
        @Id
        @SequenceGenerator(
                name = "comment_sequence",
                sequenceName = "comment_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "comment_sequence"
        )
        private Long id;
        @ManyToOne
        @JoinColumn(name="issue_id")
        private Issue issue;
        private String text;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UsersDetails user;
        public Issue getIssue() {
            return issue;
        }

        public void setIssue(Issue issue) {
            this.issue = issue;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public UsersDetails getUser() {
            return user;
        }

        public void setUser(UsersDetails user) {
            this.user = user;
        }


        public UsersDetails getUserId() {
            return user;
        }

        public void setUserId(UsersDetails userId) {
            this.user = userId;
        }

    }
