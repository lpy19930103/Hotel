package com.lipy.common.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lipy.common.utils.NoDoubleClickUtils;
import com.lipy.lib_common.R;


public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    protected boolean isRefresh = false;
    protected Bundle savedInstanceState;

    private void init() {
        initContentView();
        initTitleBar();
        initView();
        initListener();
        initPresenter();
        initLocalData();
    }

    private void initContentView() {
        if (isUseBaseTitleBar()) {
            setContentView(R.layout.activity_base);
            RelativeLayout localRelativeLayout = (RelativeLayout) findViewById(R.id.rl_gee_content_container);
            if (loadViewLayout() != 0) {
                LayoutInflater.from(this).inflate(loadViewLayout(), localRelativeLayout);
            }
        } else {
            setContentView(loadViewLayout());
        }
    }


    protected void showLoading() {

    }

    protected void hideLoading() {
    }

    private void redirectLogin() {

    }


    protected void beforeOnCreate() {
    }

    protected void beforeSetContent() {
    }



    protected abstract int loadViewLayout();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void click(View view);

    protected abstract void initLocalData();

    protected void loadData() {
    }


    protected void initPresenter() {
    }

    @Override
    public void onClick(View view) {
        if (!NoDoubleClickUtils.isDoubleClick()) {
            click(view);
        } else {
        }
    }

    protected void finishActivity() {
        finish();
    }

    protected void initTitleBar() {

    }


    protected boolean isFitsSystemWindows() {
        return true;
    }


    protected boolean isUseBaseTitleBar() {
        return false;
    }

    protected boolean isUseBaseStatusBar() {
        return true;
    }


    protected boolean isUseBaseLoading() {
        return true;
    }

    private int mKeyCode;
    private KeyEvent mEvent;

    protected boolean onKeyBack() {
        return super.onKeyDown(mKeyCode, mEvent);
    }

    protected boolean onKeyMenu() {
        return super.onKeyDown(mKeyCode, mEvent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mKeyCode = keyCode;
        mEvent = event;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return onKeyBack();
        } else if (keyCode == KeyEvent.KEYCODE_MENU) {
            return onKeyMenu();
        }
        return super.onKeyDown(keyCode, event);
    }


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle paramBundle) {
        beforeOnCreate();
        super.onCreate(paramBundle);
        savedInstanceState = paramBundle;
        beforeSetContent();
        init();
    }

    protected void onDestroy() {
        super.onDestroy();
//        if (isUseBaseStatusBar()) {
//            ImmersionBar.with(this).destroy(); //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
//        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        loadData();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }



/*
    public void showErrorTip(int paramInt) {
        ToastUtils.showShort(paramInt);
    }

    public void showErrorTip(String paramString) {
        ToastUtils.showShort(paramString);
    }

    public void showNoResponse() {
        ToastUtils.showShort("系统繁忙");
    }

    public void showSuccessTip(int paramInt) {
        ToastUtils.showShort(paramInt);
    }

    public void showSuccessTip(String paramString) {
        ToastUtils.showShort(paramString);
    }*/

//    protected int statusBarTintColor() {
//        return R.color.white;
//    }

//    protected LoadingView loadingView() {
//        return null;
//    }
}
