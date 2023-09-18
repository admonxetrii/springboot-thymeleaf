package com.interviewtest.nisham.service.abstrations;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.model.BlogDTO;

import java.util.List;

public interface BlogService {
    List<BlogDTO> getAllBlogs();
    Blog getBlogById(Integer id);
    Blog saveBlog(Blog blog);
    void deleteBlog(Integer id);
}
