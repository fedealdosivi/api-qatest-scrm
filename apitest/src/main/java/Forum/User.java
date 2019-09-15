package Forum;

public class User {

    private String name;

    private String username;

    private String password;

    private String role;

    private String email;

    public User(){

    }

    public User(String name, String username, String password, String role, String email){
        this.setName(name);
        this.setUsername(username);
        this.setPassword(password);
        this.setRole(role);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
