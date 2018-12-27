package com.skr.proworkone.home.presenter;

import com.skr.proworkone.MainActivity;
import com.skr.proworkone.api.Api;
import com.skr.proworkone.home.model.HomeListModelInter;

public class HomeListPresenter implements IHomeListPresenter,HomeListModelInter.ModuleInterface {
    private final HomeListModelInter homeListModelInter;

    MainActivity mivew;
    public HomeListPresenter(MainActivity mainActivity) {

        this.mivew = mainActivity;
        homeListModelInter = new HomeListModelInter(this);
    }

    @Override
    public void getModelData() {
        //回调model
        homeListModelInter.getData(Api.SHOPLIST);
    }

    @Override
    public void LoadSuccess(String data) {
        mivew.getViewData(data);
    }

    @Override
    public void LoadFailed() {
        mivew.getViewData("加载失败");
    }
}
