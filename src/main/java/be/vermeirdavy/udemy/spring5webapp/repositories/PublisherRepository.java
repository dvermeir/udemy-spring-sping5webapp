package be.vermeirdavy.udemy.spring5webapp.repositories;

import be.vermeirdavy.udemy.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
