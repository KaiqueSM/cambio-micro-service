package br.com.erudio.cambioservice.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Cambio implements Serializable {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;

    public Cambio() {
    }

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }
}
