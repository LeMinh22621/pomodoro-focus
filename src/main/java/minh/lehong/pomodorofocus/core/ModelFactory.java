package minh.lehong.pomodorofocus.core;

import minh.lehong.pomodorofocus.model.HomePageRepository;
import minh.lehong.pomodorofocus.model.LoginRepository;
import minh.lehong.pomodorofocus.model.impl.HomePageRepositoryImpl;
import minh.lehong.pomodorofocus.model.impl.LoginRepositoryImpl;

public class ModelFactory {
    private LoginRepository loginRepository;
    private HomePageRepository homePageRepository;

    public LoginRepository getLoginRepository() {
        if (loginRepository == null) {
            loginRepository = new LoginRepositoryImpl();
        }
        return loginRepository;
    }

    public HomePageRepository getHomePageRepository() {
        if (homePageRepository == null) {
            homePageRepository = new HomePageRepositoryImpl();
        }
        return homePageRepository;
    }
}
