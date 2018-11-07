package laiwei.structures.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.StructuresApplication;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(StructuresApplication application) {
        this.context = application;
    }

    @Provides
    @Singleton
    public Context provideApplication(){
        return context;
    }
}
