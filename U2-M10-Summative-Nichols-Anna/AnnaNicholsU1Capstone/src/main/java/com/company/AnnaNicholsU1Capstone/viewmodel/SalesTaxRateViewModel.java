package com.company.AnnaNicholsU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRateViewModel {

    @NotEmpty
    @Size(max = 2)
    private String state;
    @NotEmpty
    @DecimalMax("999.99")
    private BigDecimal rate;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal findStateTax(String state){

        switch (state){
            case "AL":
            case "WV":
            case "WA":
            case "TN":
            case "ND":
            case "NC":
            case "NM":
            case "NJ":
            case "MO":
            case "MS":
            case "MA":
            case "LA":
            case "IN":
            case "IL":
            case "HI":
            case "DE":
                return new BigDecimal(".05");

            case "AK":
            case "VA":
            case "SD":
            case "SC":
            case "PA":
            case "NY":
            case "NH":
            case "MN":
            case "MI":
            case "KS":
            case "FL":
            case "CA":
            case "AR":
                return new BigDecimal(".06");
                
            case "AZ":
            case "WY":
            case "UT":
            case "OK":
            case "OH":
            case "NV":
            case "NE":
            case "KY":
            case "IA":
            case "CO":
                return new BigDecimal(".04");
            
            case "CT":
            case "WI":
            case "TX":
            case "MT":
            case "ME":
            case "ID":
                return new BigDecimal(".03");
            
            case "GA":
            case "VT":
            case "RI":
            case "OR":
            case "MD":
                return new BigDecimal(".07");
            
        }

        return new BigDecimal(".00");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRateViewModel that = (SalesTaxRateViewModel) o;
        return Objects.equals(state, that.state) &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }
}
