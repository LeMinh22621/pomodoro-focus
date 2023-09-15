package minh.lehong.pomodorofocus.core;

import minh.lehong.pomodorofocus.viewmodel.LoginViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        return new LoginViewModel(modelFactory.getLoginRepository());
    }
}
