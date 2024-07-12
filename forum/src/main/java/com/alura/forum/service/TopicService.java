package com.alura.forum.service;

import com.alura.forum.core.crud.CrudService;
import com.alura.forum.model.entity.Answer;
import com.alura.forum.model.entity.Topic;
import com.alura.forum.model.entity.User;
import com.alura.forum.model.entity.enums.TopicStatus;
import com.alura.forum.model.projections.TopicCompleteDTO;
import com.alura.forum.model.projections.TopicSlimDTO;
import com.alura.forum.repository.AnswerRepository;
import com.alura.forum.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService extends CrudService<Topic, Long> {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    protected Topic editEntity(Topic oldEntity, Topic entityToSave) {
        oldEntity.setCategory(entityToSave.getCategory());
        oldEntity.setSubcategory(entityToSave.getSubcategory());
        oldEntity.setCourse(entityToSave.getCourse());
        oldEntity.setMessage(entityToSave.getMessage());
        oldEntity.setTitle(entityToSave.getTitle());
        return oldEntity;
    }

    @Override
    public Topic save(Topic entity) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setAuthor(user);
        return super.save(entity);
    }

    public Page<TopicSlimDTO> findAllSlim(Pageable pageable) {
        return topicRepository.findAllBy(pageable);
    }

    public TopicCompleteDTO findComplete(Long id) {
        return topicRepository.findTopicCompleteById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic with id " + id + " not found!"));
    }

    public Answer addAnswerToPost(Answer answer, Long idPost) {
        Topic topic = getReferenceByIdIfExist(idPost);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        answer.setTopic(topic);
        answer.setCreatedAt(LocalDateTime.now());
        answer.setAuthor(user);
        if (topicRepository.findStatusById(idPost) == 1) {
            topic.setStatus(TopicStatus.NAO_SOLUCIONADO.getId());
        }
        return answerRepository.save(answer);
    }

    @Override
    public Topic getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Topic with id " + id + " not exist!");
        return getReferenceById(id);
    }

}
