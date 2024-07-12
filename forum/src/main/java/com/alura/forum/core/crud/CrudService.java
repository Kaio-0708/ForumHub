package com.alura.forum.core.crud;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CrudService<E, ID> {

    @Autowired
    protected CrudRepository<E, ID> repository;

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resource with id " + id + " not exist!"));
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public E edit(ID id, E entityToSave) {
        E oldEntity = findById(id);
        E entityEdited = editEntity(oldEntity, entityToSave);
        return repository.save(entityEdited);
    }

    protected abstract E editEntity(E oldEntity, E entityToSave);

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void delete(E e) {
        repository.delete(e);
    }

    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    public E getReferenceById(ID id) {
        return repository.getReferenceById(id);
    }

    public abstract E getReferenceByIdIfExist(ID id);

}