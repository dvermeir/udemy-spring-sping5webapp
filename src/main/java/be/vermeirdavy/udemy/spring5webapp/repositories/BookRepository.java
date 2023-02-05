package be.vermeirdavy.udemy.spring5webapp.repositories;

import be.vermeirdavy.udemy.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
