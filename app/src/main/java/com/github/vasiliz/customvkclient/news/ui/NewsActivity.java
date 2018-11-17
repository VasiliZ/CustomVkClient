package com.github.vasiliz.customvkclient.news.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.vasiliz.customvkclient.CustomVkClient;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.commons.Strings;
import com.github.vasiliz.customvkclient.entities.ResponseNews;
import com.github.vasiliz.customvkclient.news.NewsPresenter;
import com.github.vasiliz.customvkclient.news.adapters.NewsAdapter;
import com.github.vasiliz.customvkclient.news.adapters.OnItemClickListener;
import com.github.vasiliz.customvkclient.news.di.NewsComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsView, OnItemClickListener {

    @BindView(R.id.navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.news_items)
    RecyclerView mContentNews;
    @BindView(R.id.news_progress_ber)
    ProgressBar mProgressNews;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Inject
    NewsPresenter mNewsPresenter;
    @Inject
    NewsAdapter mNewsAdapter;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_container);
        ButterKnife.bind(this);
        setUpInjection();
        setUpRecyclerView();
        mSharedPreferences = getSharedPreferences(Strings.APP_PREFERENCES, MODE_PRIVATE);
        mNewsPresenter.getNews();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mNewsPresenter.getNews();
            }
        });
    }

    private void setUpInjection() {
        CustomVkClient customVkClient = (CustomVkClient) getApplication();
        NewsComponent newsComponent = customVkClient.getNewsComponent(this, this, this);
        newsComponent.inject(this);
    }

    private void setUpRecyclerView() {
        mContentNews.setLayoutManager(new LinearLayoutManager(this));
        mContentNews.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mContentNews.setAdapter(mNewsAdapter);
    }

    @Override
    public void showNews() {
        mContentNews.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNews() {
        mContentNews.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        mProgressNews.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressNews.setVisibility(View.GONE);
    }

    @Override
    public String getToken() {
        return mSharedPreferences.getString(Strings.APP_TOKEN_NAME, "");
    }

    @Override
    public void likePost() {
        mNewsPresenter.likePost();
    }

    @Override
    public void endRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError(String pError) {
        Toast.makeText(this, pError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(ResponseNews pResponse) {
        mNewsAdapter.setItems(pResponse);
    }

    @Override
    public void onItemClick(int pOwnerId, int pPostId) {
        Log.d("COUNT ITEM", String.valueOf(pOwnerId) + " " + pPostId);
    }

    @Override
    protected void onPause() {
        mNewsPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mNewsPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        mNewsPresenter.onResume();
        super.onResume();
    }
}
