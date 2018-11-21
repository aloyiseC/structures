package laiwei.structures.di.component;

import javax.inject.Singleton;

import dagger.Component;
import laiwei.structures.di.module.AppModule;
import laiwei.structures.di.module.DbModule;
import laiwei.structures.di.module.MainModule;
import laiwei.structures.di.module.NetworkModule;
import laiwei.structures.di.module.RepositoryModule;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class,DbModule.class})
@Singleton
public interface AppComponent {
    MainComponent addSub(MainModule mainModule);
}
