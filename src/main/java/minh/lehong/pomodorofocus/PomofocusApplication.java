package minh.lehong.pomodorofocus;

import javafx.application.Application;
import javafx.stage.Stage;
import minh.lehong.pomodorofocus.core.ModelFactory;
import minh.lehong.pomodorofocus.core.ViewHandler;
import minh.lehong.pomodorofocus.core.ViewModelFactory;

import java.io.IOException;

public class PomofocusApplication extends Application {
    @Override
    public void start(Stage stage) {
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start();
    }
}