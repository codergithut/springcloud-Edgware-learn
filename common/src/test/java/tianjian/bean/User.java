package tianjian.bean;

public class User {
    private long id;
    private String username;
    private String vin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public User(long id, String username, String vin) {
        this.id = id;
        this.username = username;
        this.vin = vin;
    }
}
