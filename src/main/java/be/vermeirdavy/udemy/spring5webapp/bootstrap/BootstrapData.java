package be.vermeirdavy.udemy.spring5webapp.bootstrap;

import be.vermeirdavy.udemy.spring5webapp.domain.Author;
import be.vermeirdavy.udemy.spring5webapp.domain.Book;
import be.vermeirdavy.udemy.spring5webapp.domain.Publisher;
import be.vermeirdavy.udemy.spring5webapp.repositories.AuthorRepository;
import be.vermeirdavy.udemy.spring5webapp.repositories.BookRepository;
import be.vermeirdavy.udemy.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args)  {
        Publisher lifeBooks = new Publisher("Live books", "Unicorn lane 2" , "Dreamville", "1237");
        publisherRepository.save(lifeBooks);

        Author wouters = new Author("Leslie", "Wouters");
        Author vermeir = new Author("Davy", "Vermeir");

        Book aLifeOfJoy = new Book("A life of joy", "399933");
        Book newJobAfter40 = new Book("A new job after 40", "54564654");

        wouters.addBook(aLifeOfJoy);
        aLifeOfJoy.addAuthor(wouters);
        aLifeOfJoy.setPublisher(lifeBooks);
        lifeBooks.addBook(aLifeOfJoy);

        vermeir.addBook(newJobAfter40);
        newJobAfter40.addAuthor(vermeir);
        newJobAfter40.setPublisher(lifeBooks);
        lifeBooks.addBook(newJobAfter40);

        authorRepository.save(wouters);
        authorRepository.save(vermeir);
        bookRepository.save(aLifeOfJoy);
        bookRepository.save(newJobAfter40);
        publisherRepository.save(lifeBooks);


        System.out.println("Started in bootstrap");
        System.out.printf("Number of books: %s%n", bookRepository.count());
        System.out.printf("Number of publishers: %s%n", publisherRepository.count());
    }
}
