package be.hepl.springavecrepository.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Account {

    @Id
    private long accountId;
    private String bankName;
    private double prix;


    public Account(int i, String test1, double v) {
        accountId = i;
        bankName = test1;
        prix = v;
    }

    public Account() {

    }

    public long getaccountId() {
        return accountId;
    }

    public String getBankName() {
        return bankName;
    }

    public double getaccountAmount() {
        return prix;
    }
}
