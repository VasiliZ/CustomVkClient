package com.github.vasiliz.customvkclient.login;

import android.net.Uri;

import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.login.events.LoginEvent;

public class LoginRepositoryImpl implements LoginRepository {

    private EventBus mEventBus;


    public LoginRepositoryImpl(EventBus pEventBus) {
        mEventBus = pEventBus;

    }

    @Override
    public void getToken(String containsToken) {
        final String tokenConteiner = containsToken;

        Thread thread = new Thread() {

            @Override
            public void run() {
                Uri uri = Uri.parse(tokenConteiner);

                final String[] parameters = uri.getFragment().split("\\&");
                for (String s : parameters) {
                    final String[] parts = s.split("\\=");
                    if (parts[0].equals("access_token")) {
                        if (parts.length == 1) {
                            post("Missing access token", null);
                            throw new RuntimeException("Missing access token");
                        }
                        post(null, parts[1]);
                    }
                }

            }
        };
        thread.run();
    }

    private void post(String error, String token) {
        LoginEvent loginEvent = new LoginEvent(error, token);
        loginEvent.setError(error);
        loginEvent.setResponse(token);
        mEventBus.post(loginEvent);
    }
}




