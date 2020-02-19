package com.northwind.catalogservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.exceptions.MySQLStatementCancelledException;
import com.northwind.catalogservice.api.CategoryMapper;
import com.northwind.catalogservice.api.CategoryModel;
import com.northwind.catalogservice.domain.Category;
import com.northwind.catalogservice.domain.Product;
import com.northwind.catalogservice.domain.ProductCreatedEvent;
import com.northwind.catalogservice.repository.CategoryRepository;
import com.northwind.catalogservice.repository.ProductRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public CategoryService(CategoryRepository categoryRepository, RabbitTemplate rabbitTemplate) {
        this.categoryRepository = categoryRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<Category> getAll(int page, int size){
        return categoryRepository.findAll(PageRequest.of(page,size)).toList();
    }

    public Category save(Category category)  {
        Category savedCategory = categoryRepository.save(category);
        if(savedCategory==null){
            throw new NullPointerException();
        }

        return savedCategory;

    }

    public Optional<Category> getbyId(long categoryId){
        return categoryRepository.findById(categoryId);
    }
}
