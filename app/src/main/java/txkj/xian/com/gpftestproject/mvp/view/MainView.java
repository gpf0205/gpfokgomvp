package txkj.xian.com.gpftestproject.mvp.view;

import java.util.List;

import txkj.xian.com.gpftestproject.base.BaseView;

/**
 * Created by AnOnYm on 2019/9/24.
 */

public interface MainView extends BaseView {
    void onSuccess(List<? extends Object> list);
}
