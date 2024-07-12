package com.alura.forum.converter;

import com.alura.forum.core.crud.CrudConverter;
import com.alura.forum.model.dto.request.CourseDTO;
import com.alura.forum.model.dto.response.CourseResponseDTO;
import com.alura.forum.model.entity.Course;
import com.alura.forum.repository.Subcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements CrudConverter<Course, CourseDTO, CourseResponseDTO> {

    @Autowired
    Subcat subcategoryRepository;

    @Override
    public Course dtoCadToEntity(CourseDTO dtocad) {
        Course course = new Course();
        course.setName(dtocad.getNome());
        course.setSubcategory(subcategoryRepository.getReferenceById(dtocad.getSubcategoryId()));
        return course;
    }

    @Override
    public CourseResponseDTO entityToDTOResponse(Course entity) {
        if (entity == null) return null;
        return new CourseResponseDTO(entity.getId(), entity.getName());
    }
}
