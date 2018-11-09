package laiwei.structures.repository;

import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
public class AccountRepository {

    //https://passport.tianya.cn/ssl/login.do
    private static final String HTTPS = "https://passport.tianya.cn/";
    private Retrofit.Builder builder;

    public AccountRepository(Retrofit.Builder builder,StructrueConverterFactory structrueConverterFactory) {
        this.builder = builder;
        builder.addConverterFactory(structrueConverterFactory);
    }
}
