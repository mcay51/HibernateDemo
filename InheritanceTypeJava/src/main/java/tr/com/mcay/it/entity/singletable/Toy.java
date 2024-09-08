package tr.com.mcay.it.entity.singletable;

import jakarta.persistence.Entity;

@Entity
public class Toy extends SingleTable {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
//getters and setter omitted for brevity

}
