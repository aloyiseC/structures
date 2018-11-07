package laiwei.structures.di.component;

import javax.inject.Singleton;

import dagger.Component;
import laiwei.structures.di.module.AppModule;
import laiwei.structures.di.module.MainModule;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    MainComponent addSub(MainModule mainModule);
}
