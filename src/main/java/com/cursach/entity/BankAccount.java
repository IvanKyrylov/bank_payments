package com.cursach.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "num")
    private int num;

    @Column(name = "credit")
    private int credit;

    @Column(name = "percent")
    private int percent;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "return_time")
    private Timestamp returnTime;

    @Column(name = "cash")
    private int cash;

    @Column(name = "deposit_rate")
    private int deposit_rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReplenishmentHistory> replenishmentHistorys = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDeposit_rate() {
        return deposit_rate;
    }

    public void setDeposit_rate(int deposit_rate) {
        this.deposit_rate = deposit_rate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<ReplenishmentHistory> getReplenishmentHistorys() {
        return replenishmentHistorys;
    }

    public void setReplenishmentHistorys(List<ReplenishmentHistory> replenishmentHistorys) {
        this.replenishmentHistorys = replenishmentHistorys;
    }
}
