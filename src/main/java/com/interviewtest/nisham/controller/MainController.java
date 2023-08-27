package com.interviewtest.nisham.controller;

import com.interviewtest.nisham.service.abstrations.BlogService;
import com.interviewtest.nisham.service.abstrations.CategoryService;
import com.interviewtest.nisham.service.abstrations.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final BlogService blogService;
    private final CategoryService categoryService;
    private final TagService tagService;

    @GetMapping("login")
    public String login() {
        return "/login";
    }

    @GetMapping("dashboard")
    public String dashboard(Model model) {
        model.addAttribute("listOfBlogs", blogService.getAllBlogs());
        model.addAttribute("listOfCategories", categoryService.getAllCategories());
        model.addAttribute("listOfTags", tagService.getAllTags());
        return "/dashboard";
    }
}
