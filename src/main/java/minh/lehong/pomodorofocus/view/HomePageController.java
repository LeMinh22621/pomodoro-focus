package minh.lehong.pomodorofocus.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minh.lehong.pomodorofocus.core.ViewHandler;
import minh.lehong.pomodorofocus.viewmodel.HomePageViewModel;

public class HomePageController {
    @FXML
    private Label currentSessionLabel;
    @FXML
    private Label currentMinutesLabel;
    @FXML
    private Label currentSecondsLabel;
    private HomePageViewModel homePageViewModel;
    private ViewHandler viewHandler;

    public void startAction() {
        this.homePageViewModel.startAction();
    }

    public void init(ViewHandler viewHandler, HomePageViewModel homePageViewModel) {
        this.viewHandler = viewHandler;
        this.homePageViewModel = homePageViewModel;

        // binding properties
        this.currentSessionLabel.textProperty().bindBidirectional(homePageViewModel.currentSessionProperty(), java.text.NumberFormat.getIntegerInstance());
        this.currentMinutesLabel.textProperty().bindBidirectional(homePageViewModel.minutePropertyProperty(), java.text.NumberFormat.getIntegerInstance());
        this.currentSecondsLabel.textProperty().bindBidirectional(homePageViewModel.secondPropertyProperty(), java.text.NumberFormat.getIntegerInstance());
    }
}
