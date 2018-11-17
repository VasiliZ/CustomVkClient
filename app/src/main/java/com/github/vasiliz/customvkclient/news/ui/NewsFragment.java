package com.github.vasiliz.customvkclient.news.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class NewsFragment extends Fragment implements NewsView, OnItemClickListener {

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

    public NewsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_container,container,false);
        ButterKnife.bind(this, view);
        setUpInjection();
        setUpRecyclerView();
        mSharedPreferences = getActivity().getSharedPreferences(Strings.APP_PREFERENCES, getActivity().MODE_PRIVATE);
        mNewsPresenter.getNews();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mNewsPresenter.getNews();
            }
        });
        return view;
    }


    private void setUpInjection() {
        CustomVkClient customVkClient = (CustomVkClient) getActivity().getApplication();
        NewsComponent newsComponent = customVkClient.getNewsComponent( this, this);
        newsComponent.inject(this);
    }

    private void setUpRecyclerView() {
        mContentNews.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        Toast.makeText(getActivity(), pError, Toast.LENGTH_SHORT).show();
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
    public void onPause() {
        mNewsPresenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mNewsPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        mNewsPresenter.onResume();
        super.onResume();
    }
}
