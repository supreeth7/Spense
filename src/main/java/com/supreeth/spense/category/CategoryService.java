package com.supreeth.spense.category;

import com.supreeth.spense.exceptions.BadRequestException;
import com.supreeth.spense.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(String title, String description, Integer user_id) throws BadRequestException {
        try {
            Category category = new Category(title, description, user_id);
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new BadRequestException("Bad request. Cannot add category.");
        }
    }

    public List<Category> getAllCategories(Integer user_id) throws ResourceNotFoundException {
        try {
            List<Category> categories = new ArrayList<>();
            categories.addAll(categoryRepository.findByUserId(user_id));
            if (categories.isEmpty()) throw new ResourceNotFoundException("No records found.");
            return categories;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No records found.");
        }
    }

    public Category getCategory(Integer user_id, Integer id) throws ResourceNotFoundException {
        try {
            Category category = categoryRepository.findByUserIdAndId(user_id, id);
            if (category == null) throw new ResourceNotFoundException("No record found.");
            return category;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No record found.");
        }
    }

    public Category updateCategory(Integer user_id, Integer id, String title, String description) throws ResourceNotFoundException {
        try {
            Category cat = categoryRepository.findByUserIdAndId(user_id, id);
            if (cat == null) throw new ResourceNotFoundException("No record found.");
            cat.setTitle(title);
            cat.setDescription(description);
            return categoryRepository.save(cat);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No record found.");
        }
    }

    public ResponseEntity<Map<String, String>> removeCategory(Integer user_id, Integer id) throws ResourceNotFoundException {
        try {
            Category category = categoryRepository.findByUserIdAndId(user_id, id);
            if (category == null) throw new ResourceNotFoundException("No category record found");
            categoryRepository.delete(category);
            Map<String, String> m = new HashMap();
            String message = "Deletion successful";
            m.put("message", message);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No category record found");
        }
    }

}
