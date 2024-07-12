package com.alura.forum.controller;

import com.alura.forum.converter.AnswerConverter;
import com.alura.forum.core.crud.CrudController;
import com.alura.forum.model.dto.request.AnswerDTO;
import com.alura.forum.model.dto.request.TopicDTO;
import com.alura.forum.model.dto.response.AnswerResponseDTO;
import com.alura.forum.model.dto.response.TopicResponseDTO;
import com.alura.forum.model.entity.Answer;
import com.alura.forum.model.entity.Topic;
import com.alura.forum.model.projections.AnswerSlim;
import com.alura.forum.model.projections.TopicCompleteDTO;
import com.alura.forum.model.projections.TopicSlimDTO;
import com.alura.forum.service.AnswerService;
import com.alura.forum.service.TopicService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController extends CrudController<Topic, Long, TopicDTO, TopicResponseDTO> {

    private TopicService topicService;
    private AnswerService answerService;
    private AnswerConverter answerConverter;

    @Override
    public ResponseEntity<Page<TopicSlimDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(topicService.findAllSlim(pageable));
    }

    @Override
    public ResponseEntity<TopicCompleteDTO> findById(@PathVariable("id") Long aLong) {
        return ResponseEntity.ok(topicService.findComplete(aLong));
    }

    @GetMapping("/{id}/answers")
    public ResponseEntity<Page<AnswerSlim>> findAnswersByTopic(@PathVariable("id") Long id, Pageable pageable) {
        Page<AnswerSlim> answers = answerService.findAllByTopicId(id, pageable);
        return ResponseEntity.ok(answers);
    }

    @Transactional
    @PostMapping("/{id}/answers")
    public ResponseEntity<AnswerResponseDTO> addAnswerToPost(@PathVariable("id") Long id, @RequestBody @Valid AnswerDTO answerDTO) {
        Answer answer = answerConverter.dtoCadToEntity(answerDTO);
        Answer answer1 = topicService.addAnswerToPost(answer, id);
        return ResponseEntity.ok(answerConverter.entityToDTOResponse(answer1));
    }


}
