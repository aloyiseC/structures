package laiwei.structures.presenter;

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
        iMainBiz.login(null);
    }
}
