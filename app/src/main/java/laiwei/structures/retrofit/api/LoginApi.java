package laiwei.structures.retrofit.api;

import io.reactivex.Observable;
import laiwei.structures.retrofit.bean.HttpResult;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by laiwei on 2018/11/9 0009.
 */
public interface LoginApi {
    @POST("ssl/login.do")
    Observable<HttpResult> login(@Field("userName")String userName, @Field("dPassword")String pwd);
}
