package com.interviewtest.nisham.controller;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.model.BlogDTO;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final CategoryService categoryService;
    private final TagService tagService;

    @GetMapping("getAllBlogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

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
    public ResponseEntity<String> deleteBlog(@PathVariable("id") Integer id) {
        try {
            blogService.deleteBlog(id);
            return ResponseEntity.ok("Blog deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
