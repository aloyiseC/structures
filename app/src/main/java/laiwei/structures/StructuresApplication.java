package laiwei.structures;

import android.app.Application;
import android.content.Context;

import laiwei.structures.di.component.AppComponent;
import laiwei.structures.di.component.DaggerAppComponent;
import laiwei.structures.di.module.AppModule;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public class StructuresApplication extends Application{
    private static AppComponent appComponent;
    public static StructuresApplication get(Context context){
        return (StructuresApplication)context.getApplicationContext();
    }

    private void setAppComponent(){
         appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public  AppComponent getAppComponent() {
        if(appComponent == null)
           setAppComponent();
        return appComponent;
    }
}
