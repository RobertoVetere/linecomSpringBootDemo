package com.holidevs.demoSpring.categoryTest;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Transactional
public class CategoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        Category shoes = new Category("shoes");
        Category books = new Category("books");
        Category electronics = new Category("electronics");

        categoryRepository.save(shoes);
        categoryRepository.save(books);
        categoryRepository.save(electronics);
    }

    @Test
    void testFindAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        assertEquals(3, categories.size());
    }

    @Test
    void testFindCategoryByName() {
        Optional<Category> categoryOptional = categoryRepository.findByName("shoes");
        assertTrue(categoryOptional.isPresent());
        assertEquals("shoes", categoryOptional.get().getName());
    }

    @Test
    void testCreateCategory() {
        Category newCategory = new Category("toys");
        categoryRepository.save(newCategory);

        Optional<Category> savedCategory = categoryRepository.findByName("toys");
        assertTrue(savedCategory.isPresent());
        assertEquals("toys", savedCategory.get().getName());
    }

    @Test
    @Transactional
    void testDeleteCategory() {
        categoryRepository.deleteByName("electronics");
        Optional<Category> deletedCategory = categoryRepository.findByName("electronics");
        assertTrue(deletedCategory.isEmpty());
    }

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAll();
    }
}
