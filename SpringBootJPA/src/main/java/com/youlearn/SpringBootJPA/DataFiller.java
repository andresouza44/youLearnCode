package com.youlearn.SpringBootJPA;

import com.youlearn.SpringBootJPA.model.Account;
import com.youlearn.SpringBootJPA.model.AccountType;
import com.youlearn.SpringBootJPA.model.BankUser;
import com.youlearn.SpringBootJPA.model.Card;
import com.youlearn.SpringBootJPA.repository.AccountRepository;
import com.youlearn.SpringBootJPA.repository.BankUserRepository;
import com.youlearn.SpringBootJPA.repository.CardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

    @Component
    public class DataFiller implements CommandLineRunner {
        private final BankUserRepository bankUserRepository;
        private final CardRepository cardRepository;
        private final AccountRepository accountRepository;
        public DataFiller(BankUserRepository bankUserRepository,
                          CardRepository cardRepository,
                          AccountRepository accountRepository
        ) {
            this.bankUserRepository = bankUserRepository;
            this.cardRepository = cardRepository;
            this.accountRepository = accountRepository;
        }
        @Override
        public void run(String... args) throws Exception {
            //Bank User 1
            BankUser bankUser1 = new BankUser();
            bankUser1.setName("Geo");
            bankUser1.setSurname("Pal");
            bankUser1.setTaxId("85030530");
            bankUserRepository.save(bankUser1);
            //Bank User 2
            BankUser bankUser2 = new BankUser();
            bankUser2.setName("Akis");
            bankUser2.setSurname("Pal");
            bankUser2.setTaxId("905803980");
            bankUserRepository.save(bankUser2);
            //Account 1
            Account account1 = new Account();
            account1.setAccountName("My Checking Account");
            account1.setAccountType(AccountType.CHECKING);
            account1.setIBAN("3452323259672453");
            accountRepository.save(account1);
            //Account 2
            Account account2 = new Account();
            account2.setAccountName("My Savings Account");
            account2.setAccountType(AccountType.SAVINGS);
            account2.setIBAN("5097436843736604");
            accountRepository.save(account2);
            //Account 3
            Account account3 = new Account();
            account3.setAccountName("Another Savings Account");
            account3.setAccountType(AccountType.SAVINGS);
            account3.setIBAN("3432847044115201");
            accountRepository.save(account3);
            //Users - accounts relationships
            bankUser1.setAccounts(Set.of(account1, account2));
            bankUser2.setAccounts(Set.of(account1, account3));
            bankUserRepository.save(bankUser1);
            bankUserRepository.save(bankUser2);
            //First card
            Card card1 = new Card();
            card1.setNumber("4825386157071828");
            card1.setCvv("991");
            card1.setExpirationDate("11/27");
            card1.setBankUser(bankUser1);
            card1.setAccount(account1);
            cardRepository.save(card1);
            //Second card
            Card card2 = new Card();
            card2.setNumber("4702899117785600");
            card2.setCvv("943");
            card2.setExpirationDate("11/28");
            card2.setBankUser(bankUser2);
            card2.setAccount(account2);
            cardRepository.save(card2);
            //Third card
            Card card3 = new Card();
            card3.setNumber("0959313190380584");
            card3.setCvv("745");
            card3.setExpirationDate("11/28");
            card3.setBankUser(bankUser2);
            card3.setAccount(account3);
            cardRepository.save(card3);
        }
    }

