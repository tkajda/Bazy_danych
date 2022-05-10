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
}
