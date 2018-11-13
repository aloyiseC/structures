package laiwei.structures.biz.impl;

import laiwei.structures.bean.User;
import laiwei.structures.biz.IMainBiz;
import laiwei.structures.presenter.OnLoginListener;
import laiwei.structures.repository.AccountRepository;
import laiwei.structures.retrofit.converter.StructrueConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public class MainBizImpl implements IMainBiz{

    private AccountRepository accountRepository;

    public MainBizImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void login(User user, OnLoginListener onLoginListener) {
           accountRepository.login(user,onLoginListener);
    }

}
