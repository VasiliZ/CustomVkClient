package com.github.vasiliz.customvkclient.login.libs;

import com.github.vasiliz.customvkclient.lib.base.EventBus;

public class GreenRobotEventBus implements EventBus {
    private org.greenrobot.eventbus.EventBus mEventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus pEventBus) {
        mEventBus = pEventBus;
    }

    @Override
    public void register(Object subscriber) {
        mEventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        mEventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        mEventBus.post(event);
    }
}
