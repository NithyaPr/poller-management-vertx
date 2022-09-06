package se.pollermanagement.vertx.configuration;

public class Config {

    private String url;
    private String password;
    private String userName;

    public Config(String url, String userName, String password) {
        this.url = url;
        this.password = password;
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
