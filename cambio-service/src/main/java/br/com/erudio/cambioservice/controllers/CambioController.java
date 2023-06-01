package br.com.erudio.cambioservice.controllers;

import br.com.erudio.cambioservice.model.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) {
        return new ResponseEntity<>(
                new Cambio(
                        1L,
                        from, to,
                        BigDecimal.ONE, BigDecimal.ONE,
                        environment.getProperty(
                                "local.server.port"
                        )),
                HttpStatus.OK
        );
    }
}
