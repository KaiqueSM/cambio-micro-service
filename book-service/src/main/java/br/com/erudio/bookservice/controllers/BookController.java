package br.com.erudio.bookservice.controllers;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.model.Cambio;
import br.com.erudio.bookservice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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

        HashMap<String, String> params = new HashMap<>();
        params.put("amount",book.getPrice().toString());
        params.put("from","USD");
        params.put("to",currency);

        Cambio cambio = new RestTemplate()
                .getForEntity(
                        "http://localhost:8000/cambio-service" +
                                "/{amount}/{from}/{to}",
                        Cambio.class,
                        params
                ).getBody();

        book.setEnvironment(environment.getProperty(
                "local.server.port"
        ));
        book.setPrice(cambio.getConvertedValue());
        book.setCurrency(cambio.getTo());
        return new ResponseEntity<>(
                book,
                HttpStatus.OK
        );
    }
}
