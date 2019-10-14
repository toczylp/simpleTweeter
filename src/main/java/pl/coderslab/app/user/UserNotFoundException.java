package pl.coderslab.app.user;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "User not found!";
    }
}
