/*----------------------------------------------------------------------
	FILE        : ICrudRepository.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 07.08.2023

	Abstraction of general CRUD operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.data.repository;

import java.util.Optional;

public interface ICrudRepository<T, Id> extends IRepository<T> {
    void deleteAllById(Iterable<? extends Id> ids);
    void deleteById(Id id);
    boolean existsById(Id id);
    Iterable<T> findAllById(Iterable<Id> id);
    Optional<T> findById(Id id);
}
