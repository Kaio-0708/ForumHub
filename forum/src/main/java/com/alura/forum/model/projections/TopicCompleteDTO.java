package com.alura.forum.model.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "title", "message", "createdAt", "status", "statusEnum", "category", "subcategory", "course", "answerSolution"})
public interface TopicCompleteDTO extends TopicSlimDTO {
    String getMessage();

    AnswerSlim getAnswerSolution();

}