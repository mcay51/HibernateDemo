package tr.com.mcay.it.entity.tableperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
class UserTpc extends BaseEntityTpc {

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
