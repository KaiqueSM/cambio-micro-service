package br.com.erudio.cambioservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity(name = "cambio")
public class Cambio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;
    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;
    @Column(nullable = false)
    private BigDecimal conversionFactor;
    @Transient
    private BigDecimal convertedValue;
    @Transient
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
