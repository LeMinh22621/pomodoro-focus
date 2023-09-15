module minh.lehong.pomodorofocus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens minh.lehong.pomodorofocus to javafx.fxml;
    exports minh.lehong.pomodorofocus;
    exports minh.lehong.pomodorofocus.view;
    opens minh.lehong.pomodorofocus.view to javafx.fxml;
}