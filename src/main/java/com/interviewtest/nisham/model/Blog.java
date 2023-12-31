package com.interviewtest.nisham.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interviewtest.nisham.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BLOG")
public class Blog extends BaseEntity {

    @NotEmpty(message = "Blog's title cannot be empty.")
    @Column(name = "TITLE")
    private String title;

    @NotEmpty(message = "Blog's content cannot be empty.")
    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @ToString.Exclude
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();
}
