package com.alura.forum.controller;

import com.alura.forum.core.crud.CrudController;
import com.alura.forum.model.dto.request.CourseDTO;
import com.alura.forum.model.dto.response.CourseResponseDTO;
import com.alura.forum.model.entity.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends CrudController<Course, Long, CourseDTO, CourseResponseDTO> {
}
