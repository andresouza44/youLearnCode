package model;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private AccountType accountType;

    @ManyToMany(mappedBy = "accounts")
    private Set<BankUser> bankUsers;

    @OneToOne(mappedBy ="account")
    private Card card;
    private String IBAN;

    public Account(){

    }
    public Account(Long id, String accountName, AccountType accountType, Set<BankUser> bankUsers, Card card, String IBAN) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.bankUsers = bankUsers;
        this.card = card;
        this.IBAN = IBAN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", bankUsers=" + bankUsers +
                ", card=" + card +
                ", IBAN='" + IBAN + '\'' +
                '}';
    }
}
