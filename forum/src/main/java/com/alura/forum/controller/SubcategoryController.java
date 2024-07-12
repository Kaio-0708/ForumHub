package com.alura.forum.controller;

import com.alura.forum.core.crud.CrudController;
import com.alura.forum.model.dto.request.SubcategoryDTO;
import com.alura.forum.model.dto.response.SubcategoryResponseDTO;
import com.alura.forum.model.entity.Subcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategories")
public class SubcategoryController extends CrudController<Subcategory, Long, SubcategoryDTO, SubcategoryResponseDTO> {

}
