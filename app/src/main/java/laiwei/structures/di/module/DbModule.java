package laiwei.structures.di.module;

import android.content.ContentResolver;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import laiwei.structures.db.DatabaseHelper;

/**
 * Created by laiwei on 2018/11/21 0021.
 */
@Module
public class DbModule {
    @Provides
    @Singleton
    public ContentResolver getContentResolver(Context context){
        return context.getContentResolver();
    }
}
