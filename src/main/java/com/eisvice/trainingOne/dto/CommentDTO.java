package com.eisvice.trainingOne.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.json.JSONObject;

import com.eisvice.trainingOne.entities.Comment;

@Component
public class CommentDTO {
    private ArrayList<Comment> comments;
    private int lastId = 0;

    public CommentDTO() {
        this.comments = new ArrayList<>();
    }

    public void initComments() {
        comments.add(new Comment("Новый комментик", advanceId()));
        comments.add(new Comment("Hello there", advanceId()));
        comments.add(new Comment("What's the time?", advanceId()));
        comments.add(new Comment("BLABVLA", advanceId()));
        // for (int i = 0; i < 30; i++) {
        // comments.add(new Comment("GeNeRiC ComMenT " + i));
        // }
    }

    public void add(Comment comment) {
        comment.setId(advanceId());
        comment.setCommentLength(comment.getComment().length());
        this.comments.add(comment);
    }

    public ArrayList<String> getCommentsBody() {
        return comments.stream()
                .map(Comment::getComment)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<LocalDateTime> getCommentsCreateDate() {
        return comments.stream()
                .map(Comment::getCommentCreateDateTime)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> getCommentsLength() {
        return comments.stream()
                .map(Comment::getCommentLength)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<JSONObject> getCommentTable() {
        ArrayList<JSONObject> commentTable = new ArrayList<>();
        for (Comment comment : comments) {
            JSONObject map = new JSONObject();
            map.put("ID", comment.getId());
            map.put("Comment", comment.getComment());
            map.put("Create Date",
                    comment.getCommentCreateDateTime().format(
                            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
            map.put("Length", comment.getCommentLength());
            commentTable.add(map);
        }
        return commentTable;
    }

    private int advanceId() {
        // int getId = this.lastId;
        this.lastId++;
        return this.lastId;
    }

    public String toString() {
        return comments.stream()
                .map(Comment::toString)
                .reduce("", (previousString, currentComment) -> previousString +
                        currentComment + "\n");
    }

}
