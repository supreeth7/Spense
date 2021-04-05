package com.supreeth.spense.category;

import com.supreeth.spense.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByUserId(Integer userId);

    Category findByUserIdAndId(Integer userId, Integer id);
}
