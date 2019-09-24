package com.company.AnnaNicholsU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFeeViewModel {

    @NotEmpty
    @Size(max = 20)
    private String productType;
    @NotEmpty
    @DecimalMax("9999.99")
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal findFee(String productType){

        switch (productType){
            case "TShirt":
            case "Tshirt":
            case "tshirt":
                return new BigDecimal("1.98");
            case "Console":
            case "console":
                return new BigDecimal("14.99");
            case "Game":
            case "game":
                return new BigDecimal("1.49");
        }

        return new BigDecimal(".00");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFeeViewModel that = (ProcessingFeeViewModel) o;
        return Objects.equals(productType, that.productType) &&
                Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }
}
