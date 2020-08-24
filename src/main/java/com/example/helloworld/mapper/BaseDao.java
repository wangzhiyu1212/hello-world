package com.example.helloworld.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T> {
    List<T> select(T t);

    Integer insert(T t);
}
