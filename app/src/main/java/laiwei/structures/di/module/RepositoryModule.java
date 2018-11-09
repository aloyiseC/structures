package laiwei.structures.di.module;

import android.accounts.Account;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.repository.AccountRepository;
import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
@Module
public class RepositoryModule {
    @Singleton
    @Provides
    public AccountRepository provideAccountRepository(Retrofit.Builder builder, StructrueConverterFactory structrueConverterFactory){
        return new AccountRepository(builder,structrueConverterFactory);
    }
}
