package com.eisvice.trainingOne.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.eisvice.trainingOne.entities.Comment;

@Component
public class CommentDTO {
    private ArrayList<Comment> comments;

    public CommentDTO() {
        this.comments = new ArrayList<>();
    }

    public void initComments() {
        comments.add(new Comment("Новый комментик"));
        comments.add(new Comment("Hello there"));
        comments.add(new Comment("What's the time?"));
        comments.add(new Comment("BLABVLA"));
    }

    public void add(Comment comment) {
        this.comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String toString() {
        return comments.stream()
                .map(Comment::toString)
                .reduce("", (previousString, currentComment) -> previousString +
                        currentComment + "\n");
    }
}
