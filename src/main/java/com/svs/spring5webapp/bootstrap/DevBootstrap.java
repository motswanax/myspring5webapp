package com.svs.spring5webapp.bootstrap;

import com.svs.spring5webapp.model.Author;
import com.svs.spring5webapp.model.Book;
import com.svs.spring5webapp.model.Publisher;
import com.svs.spring5webapp.repositories.AuthorRepository;
import com.svs.spring5webapp.repositories.BookRepository;
import com.svs.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author BAD
 * @version 12/02/19
 */
@Component // <- makes this a Spring bean
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    /**
     * Constructor for dependency injection. At runtime these two below will be autowired into here.
     * @param authorRepository - the autowired author repository
     * @param bookRepository - the autowired book repository
     */
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}