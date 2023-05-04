package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drink_category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Drink_category saveCategory(Drink_category drink_category) {
        if(!drink_category.isEmpty()){
            return categoryRepository.save(drink_category);
        }
        else{
            return null;
        }
    }

    @Override
    public List<Drink_category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Drink_category getCateforyById(Integer id) {
        return categoryRepository.findById(id).get();
    }
    
}
