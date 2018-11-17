package com.github.vasiliz.customvkclient.lib.di;

import android.support.v7.app.AppCompatActivity;

import com.github.vasiliz.customvkclient.lib.base.ImageLoader;
import com.github.vasiliz.customvkclient.login.libs.GlideImageLoader;
import com.github.vasiliz.customvkclient.login.libs.GreenRobotEventBus;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LibsModule {

    private AppCompatActivity mAppCompatActivity;

    public LibsModule(AppCompatActivity pAppCompatActivity) {
        mAppCompatActivity = pAppCompatActivity;
    }

    @Provides
    @Singleton
    com.github.vasiliz.customvkclient.lib.base.EventBus provideEventBus(EventBus pEventBus) {
        return new GreenRobotEventBus(pEventBus);
    }

    @Provides
    @Singleton
    EventBus provideLibryaryEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    AppCompatActivity providesActivity() {
        return this.mAppCompatActivity;
    }
}
