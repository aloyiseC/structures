package laiwei.structures.retrofit.api;

import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
public interface LoginApi {
    @POST("ssl/login.do")
    void login(@Field("userName")String userName,@Field("dPassword")String pwd);
}
