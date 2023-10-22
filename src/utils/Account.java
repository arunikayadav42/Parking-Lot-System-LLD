package utils;

public abstract class Account {
    private String username;
    private String password;
    private String accountStatus;

    private Person person;

    public abstract Boolean resetPassword();
}
