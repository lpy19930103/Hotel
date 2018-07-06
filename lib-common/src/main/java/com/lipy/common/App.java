package com.lipy.common;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.orhanobut.hawk.Hawk;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LogUtils.getConfig().setGlobalTag("lipy");
        Hawk.init(this).build();
    }

}
