package com.svs.spring5webapp.repositories;

import com.svs.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BAD
 * @version 12/02/19
 * Basically replaces that tiresome JDBC CRUD work. Urgh!
 */
public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
