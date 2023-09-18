package com.interviewtest.nisham.repository;

import com.interviewtest.nisham.model.Blog;
import com.interviewtest.nisham.model.BlogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(nativeQuery = true, value = """
                        SELECT
                            b.id,
                            b.title,
                            b.content,
                            c.name AS category,
                            GROUP_CONCAT(t.name ORDER BY t.name ASC SEPARATOR ', ') AS tags
                        FROM
                            blog b
                                LEFT JOIN
                            category c ON b.category_id = c.id
                                LEFT JOIN
                            blog_tags bt ON b.id = bt.blog_id
                                LEFT JOIN
                            tag t ON bt.tag_id = t.id
                        WHERE
                            b.id = :id
                        GROUP BY
                            b.id, b.title, b.content, c.name
            """)
    Optional<BlogDTO> findBlogById(Integer id);

    @Query(nativeQuery = true, value = """
            SELECT
                b.id,
                b.title,
                b.content,
                c.name AS category,
                GROUP_CONCAT(t.name ORDER BY t.name ASC SEPARATOR ', ') AS tags
            FROM
                blog b
                    LEFT JOIN
                category c ON b.category_id = c.id
                    LEFT JOIN
                blog_tags bt ON b.id = bt.blog_id
                    LEFT JOIN
                tag t ON bt.tag_id = t.id
            GROUP BY
                b.id, b.title, b.content, c.name
                """)
    Optional<List<BlogDTO>> getAllBlogs();
}
