package com.skr.proworkone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.skr.proworkone.home.presenter.HomeListPresenter;
import com.skr.proworkone.home.view.IHomeListView;

public class MainActivity extends AppCompatActivity implements IHomeListView {

    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = findViewById(R.id.text_view);

        //初始化presenter
        HomeListPresenter homeListPresenter = new HomeListPresenter(this);
        homeListPresenter.getModelData();
    }

    @Override
    public void getViewData(String mViewData) {
        text_view.setText(mViewData);
    }
}
