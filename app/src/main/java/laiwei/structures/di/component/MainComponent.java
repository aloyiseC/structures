package laiwei.structures.di.component;

import dagger.Component;
import dagger.Subcomponent;
import laiwei.structures.MainActivity;
import laiwei.structures.di.module.MainModule;
import laiwei.structures.di.scope.ActivityScope;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
@Subcomponent(modules = MainModule.class)
@ActivityScope
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
