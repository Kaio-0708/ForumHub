package com.alura.forum.converter;

import com.alura.forum.core.crud.CrudConverter;
import com.alura.forum.model.dto.request.SubcategoryDTO;
import com.alura.forum.model.dto.response.SubcategoryResponseDTO;
import com.alura.forum.model.entity.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryConverter implements CrudConverter<Subcategory, SubcategoryDTO, SubcategoryResponseDTO> {
    @Override
    public Subcategory dtoCadToEntity(SubcategoryDTO dtocad) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(dtocad.getNome());
        return subcategory;
    }

    @Override
    public SubcategoryResponseDTO entityToDTOResponse(Subcategory entity) {
        if (entity == null) return null;
        return new SubcategoryResponseDTO(entity.getId(), entity.getName());
    }
}
