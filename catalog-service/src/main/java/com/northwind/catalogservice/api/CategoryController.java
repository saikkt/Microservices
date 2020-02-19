package com.northwind.catalogservice.api;

import com.northwind.catalogservice.config.Secured;
import com.northwind.catalogservice.domain.Category;
import com.northwind.catalogservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @Secured()
    public ResponseEntity<List<CategoryModel>> getAll(@RequestParam(required = false) Optional<Integer> page,
                                                      @RequestParam(required = false) Optional<Integer> size){

        List<Category> category = categoryService.getAll(page.orElse(0),size.orElse(10));
        List<CategoryModel> categoryModelList = category.stream()
                                                .map(c -> CategoryMapper.toModel(c))
                                                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryModelList);
    }

    @PostMapping
    @Secured(scope = "write")
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel){
        Category savedCategory = categoryService.save(CategoryMapper.toEntity(categoryModel));
        CategoryModel savedCategoryModel = CategoryMapper.toModel(savedCategory);

        return ResponseEntity.created(URI.create("categories/"+savedCategoryModel.getCategoryId())).body(savedCategoryModel);
    }
}
