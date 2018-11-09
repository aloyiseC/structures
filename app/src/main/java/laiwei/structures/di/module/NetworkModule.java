package laiwei.structures.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.retrofit.HeaderInterceptor;
import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
@Module
public class NetworkModule {
    private static final int CONNECTION_TIMEOUT = 6;
    private static final int DATE_TIMEOUT = 50;

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HeaderInterceptor headerInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DATE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient){
        return new Retrofit.Builder().client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @Provides
    @Singleton
    public HeaderInterceptor provideHeaderInterceptor(Context context){
        return new HeaderInterceptor(context);
    }
    @Provides
    @Singleton
    public Gson provideGson(){
        return new Gson();
    }
    @Provides
    @Singleton
    public StructrueConverterFactory provideConverterFactory(Gson gson){
        return new StructrueConverterFactory(gson);
    }
}
