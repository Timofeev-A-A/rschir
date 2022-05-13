package ru.mirea.rschir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
    @Id
    private String id;

    private String email;
    private String password;

    public Users() {}

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getId() { return id; }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, email='%s', password='%s']",
                id, email, password);
    }
}
