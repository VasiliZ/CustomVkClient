package com.github.vasiliz.customvkclient.login.events;

public class LoginEvent {
    String error;
    String response;

    public LoginEvent(String pError, String pResponse) {
        error = pError;
        response = pResponse;
    }

    public String getError() {
        return error;
    }

    public void setError(String pError) {
        error = pError;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String pResponse) {
        response = pResponse;
    }
}
