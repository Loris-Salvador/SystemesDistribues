package be.hepl.springavecrepository.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private long accountId;
}
