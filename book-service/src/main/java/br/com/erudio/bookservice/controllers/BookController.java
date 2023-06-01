package br.com.erudio.bookservice.controllers;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;
    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public ResponseEntity<Book> findById(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        Book book = repository.findById(id).isPresent() ? repository.findById(id).get() : null;

        if (book == null)
            throw new RuntimeException("Book not found");

        book.setEnvironment(environment.getProperty(
                "local.server.port"
        ));
        return new ResponseEntity<>(
                book,
                HttpStatus.OK
        );
    }
}
