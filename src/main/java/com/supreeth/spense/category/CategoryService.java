package com.supreeth.spense.category;

import com.supreeth.spense.exceptions.BadRequestException;
import com.supreeth.spense.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
            categoryRepository.findByUserId(user_id).forEach(categories::add);
            if (categories == null) throw new ResourceNotFoundException("No records found.");
            return categories;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No records found.");
        }
    }

    public Category getCategory(Integer user_id, Integer id) throws ResourceNotFoundException {
        try {
            Category category = categoryRepository.findByUserIdAndId(user_id, id);
            if(category == null) throw new ResourceNotFoundException("No record found.");
            return category;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No record found.");
        }
    }
}
