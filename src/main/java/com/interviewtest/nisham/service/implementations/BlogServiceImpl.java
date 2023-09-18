package com.interviewtest.nisham.service.implementations;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.repository.BlogRepository;
import com.interviewtest.nisham.service.abstrations.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        try{
            if (blog.getId() != null) {
                Blog existingBlog = blogRepository.findById(blog.getId()).orElse(null);
                if (existingBlog != null) {
                    existingBlog.setTitle(blog.getTitle());
                    existingBlog.setContent(blog.getContent());
                    existingBlog.setCategory(blog.getCategory());
                    existingBlog.setTags(blog.getTags());
                    blog = existingBlog;
                }
            }
            blogRepository.save(blog);
            return blog;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }
}
