package laiwei.structures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import laiwei.structures.di.module.MainModule;
import laiwei.structures.ivew.IMainView;
import laiwei.structures.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView{

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StructuresApplication.get(this).getAppComponent()
                .addSub(new MainModule(this))
                .inject(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mainPresenter.login();
            }
        });
    }

    @Override
    public void showLoading() {
        Log.i("step","showLoading");
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed() {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPwd() {

    }
}
