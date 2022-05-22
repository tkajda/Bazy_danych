package ProjectBackend.Model.tickets;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Discount {
    public KnownDiscountName discountName;
    public BigDecimal discountValue;

    public Discount(KnownDiscountName discountName) {
        this.discountName = discountName;
        this.discountValue = discountName.getDiscount();
    }
    public Discount(String discountName){
        this.discountName=KnownDiscountName.valueOf(discountName);
        this.discountValue=this.discountName.getDiscount();
    }
    public Discount(KnownDiscountName discountName, BigDecimal discountValue){
        this.discountName=discountName;
        this.discountValue=discountValue;
    }
    public Discount(){

    }

    public KnownDiscountName getDiscountName() {
        return discountName;
    }

    public void setDiscountName(KnownDiscountName discountName) {
        this.discountName = discountName;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountName=" + discountName +
                ", discountValue=" + discountValue +
                '}';
    }
}
