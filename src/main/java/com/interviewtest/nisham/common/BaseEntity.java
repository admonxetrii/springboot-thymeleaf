package com.interviewtest.nisham.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private Integer id;

    @JsonIgnore
    @Column(name = "MODIFIED_BY")
    private Integer modifiedBy;

    @JsonIgnore
    @Builder.Default
    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate = LocalDateTime.now();

    @JsonIgnore
    @Column(name = "ADDED_BY", updatable = false)
    private Integer addedBy;

    @JsonIgnore
    @Builder.Default
    @Column(name = "ADDED_DATE", updatable = false)
    private LocalDateTime addedDate = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }
}
