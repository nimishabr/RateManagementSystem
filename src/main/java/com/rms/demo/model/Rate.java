package com.rms.demo.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class Rate{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rate_id_generator")
    @Column(updatable = false, nullable = false)
    private Integer rateId;

    @Column
    private String rateDescription;

    @NotNull
    @Column
    private Date rateEffectiveDate;

    @NotNull
    @Column
    private Date rateExpirationDate;

    @NotNull
    @Column
    private Integer amount;

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public String getRateDescription() {
        return rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    public Date getRateEffectiveDate() {
        return rateEffectiveDate;
    }

    public void setRateEffectiveDate(Date rateEffectiveDate) {
        this.rateEffectiveDate = rateEffectiveDate;
    }

    public Date getRateExpirationDate() {
        return rateExpirationDate;
    }

    public void setRateExpirationDate(Date rateExpirationDate) {
        this.rateExpirationDate = rateExpirationDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
