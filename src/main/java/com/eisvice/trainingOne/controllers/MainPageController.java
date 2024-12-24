package com.eisvice.trainingOne.controllers;

// Spring boot imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Java std imports
import java.util.ArrayList;

// Internals imports
import com.eisvice.trainingOne.entities.Comment;

@Controller
public class MainPageController {
    private ArrayList<Comment> comments;

    public MainPageController() {
        this.comments = new ArrayList<>();
        initComments();
    }

    private void initComments() {
        comments.add(new Comment("Новый комментик"));
        comments.add(new Comment("Hello there"));
        comments.add(new Comment("What's the time?"));
        comments.add(new Comment("BLABVLA"));
    }
    
    @GetMapping("/")
    public String mainVew(Model model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("comments", comments);
        model.addAttribute("commentForm", new Comment());
        return "index";
    }

    @PostMapping("/comments")
    public String addComment(@ModelAttribute Comment commentForm) {
        comments.add(commentForm);
        return "redirect:/";
    }
}
