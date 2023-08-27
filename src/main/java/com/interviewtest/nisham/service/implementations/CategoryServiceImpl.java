package com.interviewtest.nisham.service.implementations;

import com.interviewtest.nisham.model.Category;
import com.interviewtest.nisham.repository.CategoryRepository;
import com.interviewtest.nisham.service.abstrations.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
