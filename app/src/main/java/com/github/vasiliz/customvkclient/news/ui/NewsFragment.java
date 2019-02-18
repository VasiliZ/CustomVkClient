package com.github.vasiliz.customvkclient.news.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.vasiliz.customvkclient.CustomVkClient;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.commons.Strings;
import com.github.vasiliz.customvkclient.entities.news.Group;
import com.github.vasiliz.customvkclient.entities.news.Item;
import com.github.vasiliz.customvkclient.entities.news.Profile;
import com.github.vasiliz.customvkclient.entities.news.ResponseNews;
import com.github.vasiliz.customvkclient.news.NewsPresenter;
import com.github.vasiliz.customvkclient.news.adapters.NewsAdapter;
import com.github.vasiliz.customvkclient.news.adapters.OnItemClickListener;
import com.github.vasiliz.customvkclient.news.di.NewsComponent;
import com.github.vasiliz.customvkclient.post.ui.PostActivity;

import java.util.List;
import java.util.Objects;

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
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.news_container, container, false);
        ButterKnife.bind(this, view);
        setUpInjection();
        setUpRecyclerView();
        mSharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences(Strings.APP_PREFERENCES, getActivity().MODE_PRIVATE);
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
        try {
            final CustomVkClient customVkClient = (CustomVkClient) getActivity().getApplication();
            final NewsComponent newsComponent = customVkClient.getNewsComponent(this, this);
            newsComponent.inject(this);
        } catch (final NullPointerException pE) {
            pE.getLocalizedMessage();
        }
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
    public void onError(final String pError) {

        Toast.makeText(getActivity(), pError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setContent(final ResponseNews pResponse) {
        mNewsAdapter.setItems(pResponse);
    }

    @Override
    public void onItemClick(final Item pItem) {
        setDataToSelectPostFromComment(pItem);
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

    private void setDataToSelectPostFromComment(final Item pItem) {
        if (getActivity() != null) {
            final Intent intent = new Intent(getContext(), PostActivity.class);
            final int postId = pItem.getPostId();
            final int sourseId = pItem.getSourseId();
            intent.putExtra(Strings.POST_ID, postId);
            intent.putExtra(Strings.SOURSE_ID, sourseId);
            startActivity(intent);
        }
    }
}
