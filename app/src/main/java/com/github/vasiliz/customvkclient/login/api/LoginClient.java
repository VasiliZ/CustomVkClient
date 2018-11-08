package com.github.vasiliz.customvkclient.login.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    private Retrofit mRetrofit;
    private static final String BASE_URL = "https://oauth.vk.com/";

    public LoginClient() {
       mRetrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }

    public LoginService getLoginService(){
        return mRetrofit.create(LoginService.class);
    }
}
