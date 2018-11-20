package laiwei.structures.presenter;

import laiwei.structures.bean.User;
import laiwei.structures.biz.IMainBiz;
import laiwei.structures.ivew.IMainView;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public class MainPresenter {

    private IMainBiz iMainBiz;
    private IMainView iMainView;

    public MainPresenter(IMainBiz iMainBiz, IMainView iMainView) {
        this.iMainBiz = iMainBiz;
        this.iMainView = iMainView;
    }

    public void login(){
        iMainView.showLoading();
        User user = new User();
        user.setName(iMainView.getUserName());
        user.setPassword(iMainView.getPwd());
        iMainBiz.login(user, new OnLoginListener() {
            @Override
            public void onLoginSuccess() {
                iMainView.hideLoading();
                iMainView.loginSuccess();
            }

            @Override
            public void onLoginFailed() {
                iMainView.hideLoading();
                iMainView.loginFailed();
            }
        });
    }
}
