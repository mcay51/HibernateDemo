package tr.com.mcay.it.entity.singletable;

import jakarta.persistence.Entity;

@Entity
public class Glasses extends SingleTable {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
//getters and setter omitted for brevity

}
