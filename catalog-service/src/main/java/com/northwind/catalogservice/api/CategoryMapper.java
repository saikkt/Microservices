package com.northwind.catalogservice.api;

import com.northwind.catalogservice.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryModel toModel(Category entity){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryId(entity.getCategoryId());
        categoryModel.setCategoryName(entity.getCategoryName());
        categoryModel.setDescription(entity.getDescription());
     //   categoryModel.setPicture(entity.getPicture());
        List<ProductModel> productModels = entity.getProductList().stream()
                                            .map(p->ProductMapper.toModel(p))
                                            .collect(Collectors.toList());
        categoryModel.setProductModelList(productModels);

        return categoryModel;
    }

    public static Category toEntity(CategoryModel categoryModel){
        Category category = new Category(categoryModel.getCategoryName());
        category.setDescription(categoryModel.getDescription());
        categoryModel.getProductModelList().stream()
                .forEach(productModel -> category.addProduct(ProductMapper.toEntity(productModel)));

        return category;
    }
}
