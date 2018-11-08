package com.github.vasiliz.customvkclient.login;

public class LoginInteractorImpl implements LoginInteractor {
    LoginRepository mLoginRepository;

    public LoginInteractorImpl(LoginRepository pLoginRepository) {
        mLoginRepository = pLoginRepository;

    }

    @Override
    public void execute(String exec) {
        mLoginRepository.getToken(exec);

    }
}
