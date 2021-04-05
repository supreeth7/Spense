package com.supreeth.spense.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @GetMapping("{id}")
    public Category get(HttpServletRequest request, @PathVariable Integer id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return categoryService.getCategory(user_id, id);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> add(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap) {
        int user_id = (Integer) request.getAttribute("user_id");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categoryService.addCategory(title, description, user_id);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> update(HttpServletRequest request, @PathVariable Integer id, @RequestBody Map<String, Object> updateFields) {
        int user_id = (Integer) request.getAttribute("user_id");
        String title = (String) updateFields.get("title");
        String description = (String) updateFields.get("description");
        Map<String, String> m = new HashMap<>();
        if (categoryService.updateCategory(user_id, id, title, description) != null) {
            m.put("message", "updated");
        }
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> delete(HttpServletRequest request, @PathVariable Integer id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return categoryService.removeCategory(user_id, id);
    }


}
