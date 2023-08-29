package com.youlearn.SpringBootJPA.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class BankUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String taxId;

    @ManyToMany
    @JoinTable(name= "bank_user_account", joinColumns = @JoinColumn(name = "bank_user_id",
            foreignKey = @ForeignKey(name="fk_bak_user_id_account")),
                inverseJoinColumns = @JoinColumn(name="account_id", foreignKey =
                    @ForeignKey( name="fk_account_id_bank_user")))
    private Set<Account> accounts = new HashSet();


    @OneToMany
    @JoinColumn(name="bank_user_id", foreignKey = @ForeignKey(name="fk_bank_user_id_cards"))
    private Set<Card> cards = new HashSet<>();

    public BankUser() {

    }
    public BankUser(Long id, String name, String taxId, Set<Account> accounts, Set<Card> cards) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
        this.accounts = accounts;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }



    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankUser bankUser = (BankUser) o;

        return Objects.equals(id, bankUser.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", account=" + accounts +
                ", cards=" + cards +
                '}';
    }
}
