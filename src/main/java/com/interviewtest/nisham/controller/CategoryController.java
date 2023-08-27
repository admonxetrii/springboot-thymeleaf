package com.interviewtest.nisham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("get-all-categories")
    public String getAllCategories() {
        return "/get-all-categories";
    }
}
