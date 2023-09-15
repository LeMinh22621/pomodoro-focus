package minh.lehong.pomodorofocus.core;

import minh.lehong.pomodorofocus.model.LoginRepository;
import minh.lehong.pomodorofocus.model.impl.LoginRepositoryImpl;

public class ModelFactory {
    private LoginRepository loginRepository;

    public LoginRepository getLoginRepository() {
        if (loginRepository == null) {
            loginRepository = new LoginRepositoryImpl();
        }
        return loginRepository;
    }
}
