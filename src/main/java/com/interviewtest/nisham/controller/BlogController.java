package com.interviewtest.nisham.controller;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.service.abstrations.BlogService;
import com.interviewtest.nisham.service.abstrations.CategoryService;
import com.interviewtest.nisham.service.abstrations.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Blog> saveBlog(@ModelAttribute("blog") Blog blog) {
        Blog savedBlog = blogService.saveBlog(blog);
        return ResponseEntity.ok(savedBlog);
    }

    @GetMapping("getBlog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Integer id, Model model) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @GetMapping("deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogService.deleteBlog(id);
        return "redirect:/dashboard";
    }
}
