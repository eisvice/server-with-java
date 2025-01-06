package com.eisvice.trainingOne.entities;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private LocalDateTime commentCreateDateTime;
    private String comment;
    private int commentLength;

    public Comment() {
        this.commentCreateDateTime = LocalDateTime.now();
    }

    public Comment(String comment, int id) {
        this.commentCreateDateTime = LocalDateTime.now();
        this.comment = comment;
        this.commentLength = comment.length();
        this.id = id;
    }

    public void addComment(String comment) {
        this.commentCreateDateTime = LocalDateTime.now();
        this.comment = comment;
        this.commentLength = comment.length();
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentLength(int commentLength) {
        this.commentLength = commentLength;
    }

    public LocalDateTime getCommentCreateDateTime() {
        return commentCreateDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentLength() {
        return commentLength;
    }

    public String toString() {
        return this.comment + " left at " + this.commentCreateDateTime + " | the length of the commet is "
                + this.commentLength;
    }
}
