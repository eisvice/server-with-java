package com.eisvice.trainingOne.controllers;

// Spring boot imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Internal imports
import com.eisvice.trainingOne.dto.CommentDTO;
import com.eisvice.trainingOne.entities.Comment;

@Controller
public class MainPageController {
    private final CommentDTO comments;

    public MainPageController(CommentDTO comments) {
        this.comments = comments;
        comments.initComments();
    }

    @GetMapping("/")
    public String mainVew(Model model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("comments", comments.getCommentTable());
        model.addAttribute("commentForm", new Comment());
        return "index";
    }

    @PostMapping("/comments")
    public String addComment(@ModelAttribute Comment commentForm) {
        comments.add(commentForm);
        return "redirect:/";
    }
}
