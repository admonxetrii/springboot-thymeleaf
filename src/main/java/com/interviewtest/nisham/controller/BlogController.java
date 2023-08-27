package com.interviewtest.nisham.controller;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.service.abstrations.BlogService;
import com.interviewtest.nisham.service.abstrations.CategoryService;
import com.interviewtest.nisham.service.abstrations.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final CategoryService categoryService;
    private final TagService tagService;

    @PostMapping("saveBlog")
    public String saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/dashboard";
    }

    @GetMapping("editBlog/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listOfCategories", categoryService.getAllCategories());
        model.addAttribute("listOfTags", tagService.getAllTags());
        model.addAttribute("blog", blogService.getBlogById(id));
        return "/editBlog";
    }

    @GetMapping("deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogService.deleteBlog(id);
        return "redirect:/dashboard";
    }
}
