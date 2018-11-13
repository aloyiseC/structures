package laiwei.structures.repository;

import laiwei.structures.bean.User;
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

    public AccountRepository(Retrofit.Builder builder,StructrueConverterFactory structrueConverterFactory) {
        this.structrueConverterFactory = structrueConverterFactory;
        this.builder = builder.addConverterFactory(structrueConverterFactory).baseUrl(HTTPS);
    }

    public void login(User user, OnLoginListener onLoginListener){
        structrueConverterFactory.setTypeClazz(User.class);
        RxUtils.rxLoad(builder.build().create(LoginApi.class).login(user.getName(), user.getPassword()),
                new RxUtils.OnFinishListener<User>() {
            @Override
            public void onNext(User user) {
                onLoginListener.onLoginSuccess();
            }

            @Override
            public boolean onError(Throwable e) {
                onLoginListener.onLoginFailed();
                return false;
            }
        });
    }
}
