package com.github.vasiliz.customvkclient.login.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginService {

    @GET("authorize?client_id=6745673&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=wall,video,friends,messages,offline&response_type=token&v=5.68&state=123456")
    Call<String> autorise();

}
