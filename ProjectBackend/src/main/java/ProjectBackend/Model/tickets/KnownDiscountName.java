package ProjectBackend.Model.tickets;

import java.math.BigDecimal;

public enum KnownDiscountName {
    STUDENT,
    WORKER,
    DISABILITY,
    NONE;

    public static KnownDiscountName getDiscountType(String name) {
        switch(name) {
            case "STUDENT":
                return STUDENT;
            case "DISABILITY":
                return DISABILITY;
            case "WORKER":
                return WORKER;
        }
        return NONE;
    }

    public BigDecimal getDiscount(){
        switch(this){
            case STUDENT:
                return BigDecimal.valueOf(0.51);
            case WORKER:
                return BigDecimal.valueOf(0.99);
            case DISABILITY:
                return BigDecimal.valueOf(0.49);
            case NONE:
                return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO;
    }
}
