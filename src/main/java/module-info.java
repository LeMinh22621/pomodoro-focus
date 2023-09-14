module minh.lehong.pomodorofocus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens minh.lehong.pomodorofocus to javafx.fxml;
    exports minh.lehong.pomodorofocus;
    exports minh.lehong.pomodorofocus.viewmodel;
    opens minh.lehong.pomodorofocus.viewmodel to javafx.fxml;
}