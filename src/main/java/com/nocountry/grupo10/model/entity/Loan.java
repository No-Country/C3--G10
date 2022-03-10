package com.nocountry.grupo10.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_loan")
    private Long idLoan;
    
    @Column(nullable = false, name = "total_amount")
    private Double totalAmount;

    @Column(name = "required_money")
    private Long requiredMoney;

    //@Column(nullable = false, name = "id_client")   //Establecer relacion con tabla user-cliente
    @OneToOne(mappedBy = "loan")
    private AppUser user;

    @Column(nullable = false, name = "interest")
    private double interest;
    
    @Column(nullable = false, name = "monthly_fee")
    private double monthlyFee;

    @Column(name = "dues")
    private Integer dues;

    @Column(name = "state")
    private Boolean state;

    
    public Loan() {
    
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getRequiredMoney() {
        return requiredMoney;
    }

    public void setRequiredMoney(Long requiredMoney) {
        this.requiredMoney = requiredMoney;
    }

    public Long getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Long idLoan) {
        this.idLoan = idLoan;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Integer getDues() {
        return dues;
    }

    public void setDues(Integer dues) {
        this.dues = dues;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}
