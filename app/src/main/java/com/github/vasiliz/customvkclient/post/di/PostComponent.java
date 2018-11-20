package com.github.vasiliz.customvkclient.post.di;

import com.github.vasiliz.customvkclient.lib.di.LibsModule;
import com.github.vasiliz.customvkclient.post.PostPresenter;
import com.github.vasiliz.customvkclient.post.ui.PostActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {LibsModule.class, PostModule.class})
public interface PostComponent {
    void inject(PostActivity pPostActivity);
    PostPresenter getPostPresenter();
}
