package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="portfolio")
public class Portfolio {

    protected Portfolio() {
        // JPA requires no-args constructor
    }

    public Portfolio(Long portfolioId, Client client, LocalDate creationDate) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.creationDate = creationDate;
    }

    @Id
    @Column(name="portfolioId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="clientId", nullable = false)
    private Client client;

    @Column(name="creationDate", nullable = false)
    private LocalDate creationDate;

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
