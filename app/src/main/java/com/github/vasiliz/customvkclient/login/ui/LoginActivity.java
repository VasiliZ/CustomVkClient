package com.github.vasiliz.customvkclient.login.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.vasiliz.customvkclient.CustomVkClient;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.login.LoginPresenter;
import com.github.vasiliz.customvkclient.login.libs.di.LoginComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.login_view)
    WebView mWebView;
    @BindView(R.id.main_progressbar)
    ProgressBar mLoginProgress;

    @Inject
    LoginPresenter mLoginPresenter;
    private static final String AUTH_URL = "https://oauth.vk.com/authorize?client_id=6745673&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=wall,video,friends,messages ,offline&response_type=token&v=5.68&state=123456";
    public static final String URL_GET_ACCESS_TOKEN = "https://oauth.vk.com/blank.html#access_token=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupInjection();

        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        mWebView.loadUrl(AUTH_URL);
        mWebView.getSettings().setJavaScriptEnabled(true);
        CustomWebViewClient customWebViewClient = new CustomWebViewClient();
        mWebView.setWebViewClient(customWebViewClient);

    }

    private void setupInjection() {
        CustomVkClient customVkClient = (CustomVkClient) getApplication();
        LoginComponent loginComponent = customVkClient.getLoginComponent(this, this);
        loginComponent.inject(this);
    }

    @Override
    public void showProgress() {
        mLoginProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mLoginProgress.setVisibility(View.GONE);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkAuth() {

    }

    @Override
    public void getToken(String token) {
        String sevr = token;
        Log.d("tokenVK", sevr);

    }

    @Override
    public void navigateToNewsScreen() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mLoginPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter.onResume();
    }

    private class CustomWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains(URL_GET_ACCESS_TOKEN)){
                mLoginPresenter.getLoginToken(url);
            }
            return false;
        }
    }
}
