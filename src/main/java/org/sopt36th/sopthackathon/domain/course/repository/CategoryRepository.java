package org.sopt36th.sopthackathon.domain.course.repository;

import java.util.List;
import org.sopt36th.sopthackathon.domain.course.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 소연
    public List<Category> findAllByName(String name);

    // 승준

}
