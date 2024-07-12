package com.alura.forum.controller;

import com.alura.forum.core.crud.CrudController;
import com.alura.forum.model.dto.request.CategoryDTO;
import com.alura.forum.model.dto.response.CategoryResponseDTO;
import com.alura.forum.model.entity.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Category, Long, CategoryDTO, CategoryResponseDTO> {

}
