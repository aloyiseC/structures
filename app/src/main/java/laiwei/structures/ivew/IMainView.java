package laiwei.structures.ivew;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public interface IMainView {
    void showLoading();
    void hideLoading();
    void loginSuccess();
    void loginFailed();
    String getUserName();
    String getPwd();
    void clearUserName();
    void clearPwd();
}
