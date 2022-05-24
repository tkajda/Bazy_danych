package ProjectBackend.Model.tickets;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Discount {
    public String discountName;
    public KnownDiscountName discountType;
    public BigDecimal discountValue;

    public Discount(String discountName) {
        this.discountName = discountName;
        this.discountType = KnownDiscountName.getDiscountType(discountName);
        this.discountValue = discountType.getDiscount();
    }

//    public KnownDiscountName getDiscountName() {
//        return discountName;
//    }
//
//    public void setDiscountName(KnownDiscountName discountName) {
//        this.discountName = discountName;
//    }
//
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
