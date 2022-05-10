package ProjectBackend.Model.tickets;

import java.math.BigDecimal;

public enum KnownDiscountName {
    STUDENT,
    WORKER,
    DISABILITY;
    public BigDecimal getDiscount(){
        switch(this){
            case STUDENT:
                return BigDecimal.valueOf(0.51);
            case WORKER:
                return BigDecimal.valueOf(0.99);
            case DISABILITY:
                return BigDecimal.valueOf(0.49);
        }
        return BigDecimal.ZERO;
    }
}
