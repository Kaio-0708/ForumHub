package com.alura.forum.converter;

import com.alura.forum.core.crud.CrudConverter;
import com.alura.forum.model.dto.request.TopicDTO;
import com.alura.forum.model.dto.response.TopicResponseDTO;
import com.alura.forum.model.entity.Category;
import com.alura.forum.model.entity.Course;
import com.alura.forum.model.entity.Subcategory;
import com.alura.forum.model.entity.Topic;
import com.alura.forum.model.entity.enums.TopicStatus;
import com.alura.forum.service.CategoryService;
import com.alura.forum.service.CourseService;
import com.alura.forum.service.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TopicConverter implements CrudConverter<Topic, TopicDTO, TopicResponseDTO> {

    CourseConverter courseConverter;
    CourseService courseService;

    CategoryConverter categoryConverter;
    CategoryService categoryService;

    SubcategoryConverter subcategoryConverter;
    SubcategoryService subcategoryService;

    @Override
    public Topic dtoCadToEntity(TopicDTO dtocad) {
        Topic topic = new Topic();
        topic.setTitle(dtocad.getTitle());
        topic.setMessage(dtocad.getMessage());
        if (dtocad.getCourseID() != null) {
            Course course = courseService.getReferenceByIdIfExist(dtocad.getCourseID());
            Subcategory subcategory = course.getSubcategory();
            Category category = subcategory.getCategory();
            topic.setCourse(course);
            topic.setSubcategory(subcategory);
            topic.setCategory(category);
        } else {
            if (dtocad.getSubcategoryId() != null)
                topic.setSubcategory(subcategoryService.getReferenceByIdIfExist(dtocad.getSubcategoryId()));
            if (dtocad.getCategoryId() != null)
                topic.setCategory(categoryService.getReferenceByIdIfExist(dtocad.getCategoryId()));
        }
        return topic;
    }

    @Override
    public TopicResponseDTO entityToDTOResponse(Topic entity) {
        return new TopicResponseDTO(entity.getId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getCreatedAt(),
                TopicStatus.findById(entity.getStatus()),
                categoryConverter.entityToDTOResponse(entity.getCategory()),
                subcategoryConverter.entityToDTOResponse(entity.getSubcategory()),
                courseConverter.entityToDTOResponse(entity.getCourse()),
                entity.getAuthor().getName()
        );
    }
}
