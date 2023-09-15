package minh.lehong.pomodorofocus.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import minh.lehong.pomodorofocus.core.ViewHandler;
import minh.lehong.pomodorofocus.viewmodel.LoginViewModel;

public class LoginController {
    // properties
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;

    // beans
    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    public void init(ViewHandler viewHandler, LoginViewModel loginViewModel) {
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;

        // binding properties
        this.emailField.textProperty().bindBidirectional(loginViewModel.emailPropertyProperty());
        this.passwordField.textProperty().bindBidirectional(loginViewModel.passwordPropertyProperty());
    }

    public void loginAction() {
        loginViewModel.loginViewModelAction();
    }
}
