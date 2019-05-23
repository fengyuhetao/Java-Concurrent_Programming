package FutureAndCallable.FirstUse;

/**
 * @author HT
 * @version V1.0
 * @package FutureAndCallable.FirstUse
 * @date 2019-05-20 20:35
 */
public class UserInfo {
    private String username;

    private String password;

    public UserInfo() {}

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
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
}
