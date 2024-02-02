/*----------------------------------------------------------------------
	FILE        : ICrudClassRepository.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 07.08.2023

	Abstraction of general CRUD operations without id

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

public interface ICrudClassRepository<T> extends IRepository<T> {
    boolean exists(T entity);
    Iterable<T> findBy(T entity);
    default Optional<T> findFirst(T entity)
    {
        return StreamSupport.stream(findBy(entity).spliterator(), false).findFirst();
    }
}
