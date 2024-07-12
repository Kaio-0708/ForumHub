package com.alura.forum.converter;

import com.alura.forum.core.crud.CrudConverter;
import com.alura.forum.model.dto.request.AnswerDTO;
import com.alura.forum.model.dto.response.AnswerResponseDTO;
import com.alura.forum.model.dto.response.UserResponseDTO;
import com.alura.forum.model.entity.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter implements CrudConverter<Answer, AnswerDTO, AnswerResponseDTO> {

    @Override
    public Answer dtoCadToEntity(AnswerDTO dtocad) {
        Answer answer = new Answer();
        answer.setMessage(dtocad.getMessage());
        return answer;
    }

    @Override
    public AnswerResponseDTO entityToDTOResponse(Answer entity) {
        return new AnswerResponseDTO(entity.getId(), entity.getMessage(), entity.getCreatedAt(), new UserResponseDTO(entity.getAuthor().getName()));
    }
}
