package minh.lehong.pomodorofocus.model.impl;

import minh.lehong.pomodorofocus.model.LoginRepository;
import minh.lehong.pomodorofocus.model.entity.User;

public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public User login(final String email, final String password) {
        User user = new User();

        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
