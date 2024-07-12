package com.alura.forum.repository;

import com.alura.forum.core.crud.CrudRepository;
import com.alura.forum.model.entity.Subcategory;
import org.springframework.stereotype.Repository;

@Repository
public interface Subcat extends CrudRepository<Subcategory, Long> {
}