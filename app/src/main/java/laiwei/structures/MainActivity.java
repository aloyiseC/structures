package laiwei.structures;

import android.database.ContentObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import laiwei.structures.db.DatabaseContentProvider;
import laiwei.structures.di.module.MainModule;
import laiwei.structures.ivew.IMainView;
import laiwei.structures.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements IMainView {

    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.username)
    EditText userNameEt;
    @BindView(R.id.pwd)
    EditText pwdEt;
    @Inject
    ContentObserver contentObserver;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StructuresApplication.get(this).getAppComponent()
                .addSub(new MainModule(this))
                .inject(this);
        getContentResolver().registerContentObserver(DatabaseContentProvider.DATABASE_URI,true,contentObserver);
    }

    @OnClick(R.id.btn)
    public void submit(View view){
        mainPresenter.login();
    }

    @Override
    public void showLoading() {
        Log.i("step", "showLoading");
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
        return userNameEt.getText().toString();
    }

    @Override
    public String getPwd() {
        return pwdEt.getText().toString();
    }

    @Override
    public void clearUserName() {
        userNameEt.setText("");
    }

    @Override
    public void clearPwd() {
        pwdEt.setText("");
    }

}
