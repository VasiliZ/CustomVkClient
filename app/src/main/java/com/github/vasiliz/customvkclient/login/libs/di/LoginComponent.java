package com.github.vasiliz.customvkclient.login.libs.di;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.login.LoginPresenter;
import com.github.vasiliz.customvkclient.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {LibsModule.class, LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity pLoginActivity);
    LoginPresenter loginPresenter();

}
