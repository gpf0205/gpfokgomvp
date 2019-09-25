package txkj.xian.com.gpftestproject.mvp.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import txkj.xian.com.gpftestproject.R;
import txkj.xian.com.gpftestproject.base.BaseMvpActivity;
import txkj.xian.com.gpftestproject.mvp.presenter.MainPresenter;
import txkj.xian.com.gpftestproject.mvp.view.MainView;

public class MainActivity extends BaseMvpActivity<MainView, MainPresenter> implements MainView {

    private int i=0;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    // 执行请求
    public void mergeTest(View view) {
        getPresenter().getAllData();
    }

    @Override
    public void showProgressDialog() {
        showLoadingDialog("加载中...");
    }

    @Override
    public void hideProgressDialog() {
        hideLoadingDialog();
   }

    @Override
    public void onError(Throwable exception) {
        Toast.makeText(this, "请求错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<? extends Object> list) {
        // 判断list
//        if(list!=null && list.size()>0){
//            if(list.get(0) instanceof BannerBean){
//                Log.d("test","请求一："+list.size());
//          }else if(list.get(0) instanceof PersonBean){
//                Log.d("test","请求二："+list.size());
//            }
//        }
        Log.d("test","数量"+(++i));
    }

}
