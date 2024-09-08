package tr.com.mcay.it.entity.joinedtable;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
class ToyJoin extends BaseItem {

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
