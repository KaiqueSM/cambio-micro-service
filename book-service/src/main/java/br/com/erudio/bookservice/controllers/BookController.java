package br.com.erudio.bookservice.controllers;

import br.com.erudio.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public ResponseEntity<Book> findById(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        String port = environment.getProperty(
                "local.server.port"
        );
        return new ResponseEntity<>(
                new Book(
                        id, "Autor", new Date(),
                        3.5,
                        "Book",
                        currency,
                        environment.getProperty(
                                "local.server.port"
                        )
                ),
                HttpStatus.OK
        );
    }
}
