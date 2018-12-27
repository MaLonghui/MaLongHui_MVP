package com.skr.proworkone.home.model;

import com.skr.proworkone.network.MyTask;

public class HomeListModelInter implements IHomelistModelInter{

    ModuleInterface modelInterface;

    public HomeListModelInter(ModuleInterface modelInterface) {
        this.modelInterface = modelInterface;
    }

    @Override
    public void getData(String url) {
        new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
            @Override
            public void result(String t) {
                if (t != null){
                    modelInterface.LoadSuccess(t);
                }else{
                    modelInterface.LoadFailed();
                }
            }
        }).execute();
    }



    public interface ModuleInterface {
        //获取数据状态的回调接口
        void LoadSuccess(String data);

        void LoadFailed();
    }
}
