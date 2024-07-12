package com.alura.forum.core.crud;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public abstract class CrudController<E extends CrudDomain<ID>, ID, DTOCAD, DTORES> {

    @Autowired
    protected CrudService<E, ID> service;
    @Autowired
    protected CrudConverter<E, DTOCAD, DTORES> converter;

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        List<E> listEntity = service.findAll();
        List<DTORES> listDTORes = listEntity
                .stream()
                .map(converter::entityToDTOResponse)
                .toList();
        return ResponseEntity.ok(listDTORes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") ID aLong) {
        E entity = service.findById(aLong);
        DTORES dtoRes = converter.entityToDTOResponse(entity);
        return ResponseEntity.ok(dtoRes);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DTOCAD e) {
        E entityConverted = converter.dtoCadToEntity(e);
        E entitySaved = service.save(entityConverted);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entitySaved.getId())
                .toUri();
        return ResponseEntity.created(uri).body(converter.entityToDTOResponse(entitySaved));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DTORES> edit(@RequestBody @Valid DTOCAD dto, @PathVariable("id") ID id) {
        E entityConverted = converter.dtoCadToEntity(dto);
        E entitySaved = service.edit(id, entityConverted);
        var a = converter.entityToDTOResponse(entitySaved);
        return ResponseEntity.ok(a);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
        if (!service.existsById(id)) throw new EntityNotFoundException("Resource with id " + id + " not exist!");
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}