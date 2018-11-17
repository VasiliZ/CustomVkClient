package com.github.vasiliz.customvkclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.vasiliz.customvkclient.news.ui.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwitchTabs extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.navigation_view)
    BottomNavigationView mBottomNavigationView;


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem pMenuItem) {
        Fragment fragment;
        switch (pMenuItem.getItemId()){
            case R.id.news_item:
                fragment = new NewsFragment();
                loadFragment(fragment);
                return true;

        }
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigator);
        ButterKnife.bind(this);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new NewsFragment());
    }

    private void loadFragment(Fragment pFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_from_fragments, pFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
