package minh.lehong.pomodorofocus.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import minh.lehong.pomodorofocus.PomofocusApplication;
import minh.lehong.pomodorofocus.view.LoginController;

public class ViewHandler {
    private Scene loginScene;

    private Stage stage;

    private ViewModelFactory viewModelFactory;

    public ViewHandler() {
        stage = new Stage();
    }

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this();
        this.viewModelFactory = viewModelFactory;
    }

    public void start() {
        this.openLoginView();
    }

    public void openLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader(PomofocusApplication.class.getResource("login-view.fxml"));
            Parent parent = loader.load();

            // init login controller
            LoginController loginController = loader.getController();
            loginController.init(this, viewModelFactory.getLoginViewModel());

            // set scene and stage
            loginScene = new Scene(parent);
            stage.setScene(loginScene);
            stage.setTitle("Login Page");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
