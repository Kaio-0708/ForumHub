package com.alura.forum.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TopicDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @NotNull
    private Long categoryId;
    private Long subcategoryId;
    private Long courseID;
}
