package laiwei.structures.di.module;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.biz.IMainBiz;
import laiwei.structures.biz.impl.MainBizImpl;
import laiwei.structures.di.scope.ActivityScope;
import laiwei.structures.ivew.IMainView;
import laiwei.structures.presenter.MainPresenter;
import laiwei.structures.repository.AccountRepository;
import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import retrofit2.Retrofit;

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
    public IMainBiz provideIMainBiz(AccountRepository accountRepository){
        return new MainBizImpl(accountRepository);
    }

    @ActivityScope
    @Provides
    public ContentObserver provideContentObserver(){
        return new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                Log.i("step","database changed");
            }
        };
    }
}
