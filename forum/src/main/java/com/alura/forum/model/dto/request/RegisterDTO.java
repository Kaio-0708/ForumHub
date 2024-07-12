package com.alura.forum.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
