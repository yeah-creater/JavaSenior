package java6354.register;

import java.util.Objects;

/**
 * @purpose: POJO类
 */
public class User6354 {
    private String username;
    private String password;
    private String phone;

    public User6354(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User6354() {
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User6354 user6354 = (User6354) o;
        return Objects.equals(username, user6354.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
