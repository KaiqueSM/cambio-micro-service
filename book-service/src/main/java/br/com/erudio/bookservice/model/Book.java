package br.com.erudio.bookservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 180)
    private String author;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, length = 250)
    private String title;
    @Transient
    private String currency;
    @Transient
    private String environment;

    public Book() {
    }

    public Book(
            Long id, String author,
            Date launchDate, Double price,
            String title, String currency,
            String environment
    ) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }
}
