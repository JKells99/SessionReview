package com.keyin.authors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Author,Long> {

    Author findAuthorByLastName(String lastName);
}
