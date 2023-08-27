package com.interviewtest.nisham.service.abstrations;

import com.interviewtest.nisham.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    Blog getBlogById(Integer id);
    void saveBlog(Blog blog);
    void deleteBlog(Integer id);
}
