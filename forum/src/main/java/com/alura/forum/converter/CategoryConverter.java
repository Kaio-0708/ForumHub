package com.alura.forum.converter;

import com.alura.forum.core.crud.CrudConverter;
import com.alura.forum.model.dto.request.CategoryDTO;
import com.alura.forum.model.dto.response.CategoryResponseDTO;
import com.alura.forum.model.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements CrudConverter<Category, CategoryDTO, CategoryResponseDTO> {

    @Override
    public Category dtoCadToEntity(CategoryDTO dtocad) {
        Category category = new Category();
        category.setName(dtocad.getNome());
        return category;
    }

    @Override
    public CategoryResponseDTO entityToDTOResponse(Category entity) {
        return new CategoryResponseDTO(entity.getId(), entity.getName());
    }
}
