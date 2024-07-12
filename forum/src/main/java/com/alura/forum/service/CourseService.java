package com.alura.forum.service;

import com.alura.forum.core.crud.CrudService;
import com.alura.forum.model.entity.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CrudService<Course, Long> {
    @Override
    protected Course editEntity(Course oldEntity, Course entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Course getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Course with id " + id + " not exist!");
        return getReferenceById(id);
    }
}
