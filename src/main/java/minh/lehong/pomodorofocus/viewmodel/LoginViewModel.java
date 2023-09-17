package minh.lehong.pomodorofocus.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import minh.lehong.pomodorofocus.model.LoginRepository;
import minh.lehong.pomodorofocus.model.entity.User;

import java.util.Objects;

public class LoginViewModel {
    // properties
    private StringProperty emailProperty = new SimpleStringProperty();;
    private StringProperty passwordProperty = new SimpleStringProperty();;
    // repository
    private LoginRepository loginRepository;

    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    // getter and setter
    public String getEmailProperty() {
        return emailProperty.get();
    }

    public StringProperty emailPropertyProperty() {
        return emailProperty;
    }

    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public StringProperty passwordPropertyProperty() {
        return passwordProperty;
    }

    public void setPasswordProperty(String passwordProperty) {
        this.passwordProperty.set(passwordProperty);
    }

    public void loginViewModelAction() {
        User user = loginRepository.login(this.getEmailProperty(), this.getPasswordProperty());
        if (Objects.nonNull(user)) {
            this.setEmailProperty("");
            this.setPasswordProperty("");
            System.out.println(user);
        }
    }
}
