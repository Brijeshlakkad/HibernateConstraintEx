package com.argusoft.exercise6.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author brijesh
 */
@Entity
public abstract class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ownerName")
    private String ownerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id")
    private CreditCard credit_card_id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bank_account_id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public CreditCard getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(CreditCard credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public BankAccount getBank_account_id() {
        return bank_account_id;
    }

    public void setBank_account_id(BankAccount bank_account_id) {
        this.bank_account_id = bank_account_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillingDetails{" + "id=" + id + ", ownerName=" + ownerName + '}';
    }

}
