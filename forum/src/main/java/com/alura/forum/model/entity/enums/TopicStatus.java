package com.alura.forum.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
public enum TopicStatus {
    SEM_RESPOSTAS(1, "SEM RESPOSTAS"),
    NAO_SOLUCIONADO(2, "NÃO SOLUCIONADO"),
    SOLUCIONADO(3, "SOLUCIONADO"),
    FECHADO(4, "FECHADO");
    private Integer id;
    private String name;

    public static TopicStatus findById(Integer id) {
        return Arrays.stream(TopicStatus.values())
                .filter(s -> Objects.equals(s.id, id))
                .findFirst().orElse(null);
    }
}