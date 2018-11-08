package com.github.vasiliz.customvkclient.login.libs.di;

import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.login.LoginInteractor;
import com.github.vasiliz.customvkclient.login.LoginInteractorImpl;
import com.github.vasiliz.customvkclient.login.LoginPresenter;
import com.github.vasiliz.customvkclient.login.LoginPresenterImpl;
import com.github.vasiliz.customvkclient.login.LoginRepository;
import com.github.vasiliz.customvkclient.login.LoginRepositoryImpl;
import com.github.vasiliz.customvkclient.login.api.LoginClient;
import com.github.vasiliz.customvkclient.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    LoginView mLoginView;

    public LoginModule(LoginView pLoginView) {
        mLoginView = pLoginView;
    }


    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus pEventBus, LoginView pLoginView, LoginInteractor pLoginInteractor){
        return new LoginPresenterImpl(pEventBus, pLoginView, pLoginInteractor);
    }

    @Provides
    @Singleton
    LoginView providesLoginView(){
        return this.mLoginView;
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository pLoginRepository){
        return new LoginInteractorImpl(pLoginRepository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus pEventBus, LoginClient pLoginClient){
        return new LoginRepositoryImpl(pEventBus, pLoginClient);
    }

    @Provides
    @Singleton
    LoginClient providesLoginClient(){
        return new LoginClient();
    }

}
