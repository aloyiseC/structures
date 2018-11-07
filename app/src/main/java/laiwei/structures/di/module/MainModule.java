package laiwei.structures.di.module;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.biz.IMainBiz;
import laiwei.structures.biz.impl.MainBizImpl;
import laiwei.structures.di.scope.ActivityScope;
import laiwei.structures.ivew.IMainView;
import laiwei.structures.presenter.MainPresenter;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
@Module
public class MainModule {
    private IMainView iMainView;

    public MainModule(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    @ActivityScope
    @Provides
    public IMainView provideIMainView(){
        return iMainView;
    }
    @ActivityScope
    @Provides
    public MainPresenter provideMainPresenter(IMainBiz iMainBiz,IMainView iMainView){
        return new MainPresenter(iMainBiz,iMainView);
    }

    @ActivityScope
    @Provides
    public IMainBiz provideIMainBiz(){
        return new MainBizImpl();
    }
}
