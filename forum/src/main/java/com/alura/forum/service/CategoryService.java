package com.alura.forum.service;

import com.alura.forum.core.crud.CrudService;
import com.alura.forum.model.entity.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, Long> {
    @Override
    protected Category editEntity(Category oldEntity, Category entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Category getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Category with id " + id + " not exist!");
        return getReferenceById(id);
    }

}
