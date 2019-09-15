package Forum;

import java.util.Random;

public class UserBuilder {

    private int randomNumber = new Random().nextInt(100000);
    private String name = "name " + randomNumber;
    private String username = "username" + randomNumber;
    private String password = "password" + randomNumber;
    private String role = "QA";
    private String email = "email@email" + randomNumber;

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder withRole(String role){
        this.role = role;
        return this;
    }

    public UserBuilder() {

    }

    public User build() {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        return user;
    }
}
