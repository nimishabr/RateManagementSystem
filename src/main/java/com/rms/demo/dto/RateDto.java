package com.rms.demo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RateDto {
    private String rateDescription;

    private Date rateEffectiveDate;

    private Date rateExpirationDate;

    private Integer amount;

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
