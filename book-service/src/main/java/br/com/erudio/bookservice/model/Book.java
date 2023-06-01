package br.com.erudio.bookservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Book implements Serializable {
    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;
    private String currency;
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
