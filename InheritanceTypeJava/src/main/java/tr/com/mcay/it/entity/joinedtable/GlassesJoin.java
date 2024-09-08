package tr.com.mcay.it.entity.joinedtable;

import jakarta.persistence.Entity;

@Entity
public class GlassesJoin extends BaseItem {
    private String brand;

    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
