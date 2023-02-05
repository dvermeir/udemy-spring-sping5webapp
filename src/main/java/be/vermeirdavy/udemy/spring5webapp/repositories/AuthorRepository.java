package be.vermeirdavy.udemy.spring5webapp.repositories;

import be.vermeirdavy.udemy.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
