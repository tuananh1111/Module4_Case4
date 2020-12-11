package com.casestudy.case4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();
    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}
