package com.svs.spring5webapp.repositories;

import com.svs.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BAD
 * @version 12/02/19
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
