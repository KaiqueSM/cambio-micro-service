package br.com.erudio.bookservice.proxy;

import br.com.erudio.bookservice.model.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    ResponseEntity<Cambio> getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );
}


