package com.interviewtest.nisham.service.implementations;

import com.interviewtest.nisham.model.Tag;
import com.interviewtest.nisham.repository.TagRepository;
import com.interviewtest.nisham.service.abstrations.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
