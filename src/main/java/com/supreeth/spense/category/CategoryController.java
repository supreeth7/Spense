package com.supreeth.spense.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAll(HttpServletRequest request) {
        int user_id = (Integer) request.getAttribute("user_id");
        List<Category> category_list = categoryService.getAllCategories(user_id);
        return category_list;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> add(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap) {
        int user_id = (Integer) request.getAttribute("user_id");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categoryService.addCategory(title, description, user_id);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Category get(HttpServletRequest request, @PathVariable Integer id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return categoryService.getCategory(user_id, id);
    }
}
