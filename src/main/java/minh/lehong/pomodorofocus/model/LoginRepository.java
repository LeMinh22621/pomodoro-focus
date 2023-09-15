package minh.lehong.pomodorofocus.model;

import minh.lehong.pomodorofocus.model.entity.User;

public interface LoginRepository {
    User login(final String email, final String password);
}
