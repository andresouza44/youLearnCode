package com.youlearn.SpringBootJPA.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String number;
    private String cvv;
    private String expirationDAte;

    @OneToOne(optional = false)
    @JoinColumn(name="account_id", foreignKey = @ForeignKey(name="fk_account_id"))
    private Account account;

    @ManyToOne(optional = false)
    private BankUser bankUser;

    public Card(){

    }
    public Card(Long id, String number, String cvv, String expirationDAte, Account account, BankUser bankUser) {
        Id = id;
        this.number = number;
        this.cvv = cvv;
        this.expirationDAte = expirationDAte;
        this.account = account;
        this.bankUser = bankUser;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDAte() {
        return expirationDAte;
    }

    public void setExpirationDAte(String expirationDAte) {
        this.expirationDAte = expirationDAte;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BankUser getBankUser() {
        return bankUser;
    }

    public void setBankUser(BankUser bankUser) {
        this.bankUser = bankUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return Objects.equals(Id, card.Id);
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Card{" +
                "Id=" + Id +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expirationDAte='" + expirationDAte + '\'' +
                ", account=" + account +
                ", bankUser=" + bankUser +
                '}';
    }
}
