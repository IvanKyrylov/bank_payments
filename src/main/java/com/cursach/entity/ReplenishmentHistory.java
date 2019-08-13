package com.cursach.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "replenishment_history")
public class ReplenishmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "replenishment_time")
    private Timestamp replenishmentTime;

    @Column(name = "sum")
    private int sum;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getReplenishmentTime() {
        return replenishmentTime;
    }

    public void setReplenishmentTime(Timestamp replenishmentTime) {
        this.replenishmentTime = replenishmentTime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
