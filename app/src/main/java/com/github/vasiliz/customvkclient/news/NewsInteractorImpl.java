package com.github.vasiliz.customvkclient.news;

public class NewsInteractorImpl implements NewsInteractor {
    private NewsRepository mNewsRepository;

    public NewsInteractorImpl(NewsRepository pNewsRepository) {
        mNewsRepository = pNewsRepository;
    }

    @Override
    public void execute(String pToken) {
        mNewsRepository.getNews(pToken);

    }

    @Override
    public void likePost() {
        mNewsRepository.like();
    }
}
