package traveller.model;

public class UserCredentials {

    private Integer id;
    private User user;
    private String password;

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

        this.id = id;
    }
    public User getUser() {

        return user;
    }
    public void setUser(User user) {

        this.user = user;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
}
