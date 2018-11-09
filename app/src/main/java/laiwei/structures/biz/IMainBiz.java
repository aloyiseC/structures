package laiwei.structures.biz;

import laiwei.structures.bean.User;
import laiwei.structures.presenter.OnLoginListener;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public interface IMainBiz {
     void login(User user, OnLoginListener onLoginListener);
}
