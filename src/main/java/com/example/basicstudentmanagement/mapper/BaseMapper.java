package com.example.basicstudentmanagement.mapper;

//@Mapper
public interface BaseMapper<T, D> {
    D entityToDTO(T entity);

    T DTOToEntity(D dto);

}
