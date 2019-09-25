package txkj.xian.com.gpftestproject.api;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okrx2.adapter.ObservableBody;

import java.io.Serializable;
import java.util.List;

import io.reactivex.Observable;
import txkj.xian.com.gpftestproject.bean.BannerBean;
import txkj.xian.com.gpftestproject.bean.PersonBean;
import txkj.xian.com.gpftestproject.helper.JsonConvert;
import txkj.xian.com.gpftestproject.helper.ResponseData;

/**
 * Created by AnOnYm on 2019/9/10.
 */

public class ApiService {

    /**
     * 首页Banner
     *
     * @GET("http://wanandroid.com/banner/json")
     */
    public static Observable<ResponseData<List<BannerBean>>> getBannerData() {
        return OkGo.<ResponseData<List<BannerBean>>>get(ApiConst.HOME_BANNER)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .converter(new JsonConvert<ResponseData<List<BannerBean>>>() {
                })
                .adapt(new ObservableBody<ResponseData<List<BannerBean>>>());
    }

    public static Observable<ResponseData<List<PersonBean>>> getPersonData() {
        return OkGo.<ResponseData<List<PersonBean>>>get(ApiConst.HOME_BANNER)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .converter(new JsonConvert<ResponseData<List<PersonBean>>>() {
                })
                .adapt(new ObservableBody<ResponseData<List<PersonBean>>>());
    }

    /**
     * 请求合并的方法,merge<=4
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData() {
        return Observable.merge(getBannerData(),getPersonData());
    }

    /**
     * 请求合并的方法,大于4个时使用mergeArray
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData1() {
        return Observable.mergeArray(getBannerData(),getPersonData(),getPersonData(),getPersonData(),getPersonData());
    }

    /**
     * 请求合并的方法，异常处理
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData2() {
        return Observable.mergeArrayDelayError(getBannerData(),getPersonData());
    }

    /**
     * 请求合并的方法
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData3() {
        return Observable.concat(getBannerData(),getPersonData());
    }

    /**
     * 请求合并的方法
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData4() {
        return Observable.concatArray(getBannerData(),getPersonData(),getPersonData(),getPersonData(),getPersonData());
    }

    /**
     * 请求合并的方法
     * @return
     */
    public static Observable<ResponseData<? extends List<? extends Serializable>>> getAllData5() {
        return Observable.concatArrayDelayError(getBannerData(),getPersonData(),getPersonData(),getPersonData(),getPersonData());
    }

}
