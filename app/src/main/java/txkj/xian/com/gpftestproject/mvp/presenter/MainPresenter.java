package txkj.xian.com.gpftestproject.mvp.presenter;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import txkj.xian.com.gpftestproject.api.ApiService;
import txkj.xian.com.gpftestproject.base.BasePresenter;
import txkj.xian.com.gpftestproject.helper.ResponseData;
import txkj.xian.com.gpftestproject.mvp.view.MainView;

/**
 * Created by AnOnYm on 2019/9/24.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public void getAllData() {
        getMvpView().showProgressDialog();
        ApiService.getAllData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseData<? extends List<? extends Object>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d("test", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull ResponseData<? extends List<? extends Object>> responseData) {
                        List<? extends Object> data = responseData.getData();
                        getMvpView().onSuccess(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getMvpView().hideProgressDialog();
                        getMvpView().onError(e);
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().hideProgressDialog();
                    }
                });
    }

}
