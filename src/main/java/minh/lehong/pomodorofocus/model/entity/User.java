package minh.lehong.pomodorofocus.model.entity;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String avatarLink;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }


    @Override
    public String toString() {
        return "Email: " + this.email + "\n" +
                "Password: " + this.password + "\n" +
                "FirstName: " + this.firstName + "\n" +
                "LastName: " + this.lastName + "\n" +
                "Avartar: " + this.avatarLink;
    }
}
