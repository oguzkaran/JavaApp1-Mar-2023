/*----------------------------------------------------------------------
	FILE        : ICrudClassRepository.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 07.08.2023

	Abstraction of general CRUD operations without id

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.repository;

public interface IRepository<T> {
    long count();
    void delete(T entity);
    void deleteAll();
    void deleteAll(Iterable<? extends T> entities);
    Iterable<T> findAll();
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
}
