package laiwei.structures.repository;

import android.content.ContentProvider;
import android.content.ContentResolver;

import laiwei.structures.bean.User;
import laiwei.structures.db.DatabaseContentProvider;
import laiwei.structures.presenter.OnLoginListener;
import laiwei.structures.retrofit.api.LoginApi;
import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import laiwei.structures.rx.RxUtils;
import retrofit2.Retrofit;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
public class AccountRepository {

    private static final String HTTPS = "https://passport.tianya.cn/";
    private Retrofit.Builder builder;
    private StructrueConverterFactory structrueConverterFactory;
    private ContentResolver resolver;

    public AccountRepository(Retrofit.Builder builder, StructrueConverterFactory structrueConverterFactory,
                             ContentResolver resolver) {
        this.structrueConverterFactory = structrueConverterFactory;
        this.builder = builder.addConverterFactory(structrueConverterFactory).baseUrl(HTTPS);
        this.resolver = resolver;
    }

    public void login(User user, OnLoginListener onLoginListener){
        structrueConverterFactory.setTypeClazz(User.class);
        resolver.insert(DatabaseContentProvider.DATABASE_URI,null);
//        RxUtils.rxLoad(builder.build().create(LoginApi.class).login(user.getName(), user.getPassword()),
//                new RxUtils.OnFinishListener<User>() {
//            @Override
//            public void onNext(User user) {
//                onLoginListener.onLoginSuccess();
//            }
//
//            @Override
//            public boolean onError(Throwable e) {
//                onLoginListener.onLoginFailed();
//                return false;
//            }
//        });
    }
}
