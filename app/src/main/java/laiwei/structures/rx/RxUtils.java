package laiwei.structures.rx;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import laiwei.structures.retrofit.bean.HttpResult;


/**
 * Created by laiwei on 2017/8/31 0031.
 */
public class RxUtils {

    public static interface OnFinishListener<T> {
        void onNext(T t);
        boolean onError(Throwable e);
    }



    public static class HttpErrorException extends Exception implements Serializable {
        private HttpResult result;

        public HttpErrorException() {
            super();
        }

        public HttpResult getClientRecvObject() {
            return result;
        }

        public void setHttpResult(HttpResult result) {
            this.result = result;
        }

        public HttpErrorException(HttpResult result) {
            super();
            this.result = result;
        }

        public HttpErrorException(String code, String message) {
            super();
            result = new HttpResult();
            result.setCode(code);
            result.setMessage(message);
        }
    }

    public static enum ResultType{
        BEAN,LIST,DEFAULT
    }

    public static <T> DisposableObserver rxLoad(Observable obserable, final OnFinishListener<T> listener
    ){

        Observable ob = obserable
                .flatMap(new Function<T,Observable<T>>() {
                    @Override
                    public Observable<T> apply(final @NonNull T t) throws Exception {

                        if(t instanceof HttpResult){
                            final HttpResult result = (HttpResult)t;
                            if (result.getSuccess() == HttpResult.SUCCESS && result.getCode() == HttpResult.CODE_SUCCESS) {
                                return Observable.create(new ObservableOnSubscribe<T>(){
                                    @Override
                                    public void subscribe(@NonNull ObservableEmitter<T> e) throws Exception {
                                        e.onNext((T) result.getData());
                                        e.onComplete();
                                    }
                                });
                            } else {
                                return Observable.error(new HttpErrorException(result));
                            }
                        }else{
                            return Observable.error(new HttpErrorException((HttpResult)t));
                        }
                    }
                })
                .subscribeOn(Schedulers.io());

        DisposableObserver disposableObserver = new DisposableObserver<T>() {
            @Override
            public void onNext(T t) {
                if(listener != null){
                    listener.onNext(t);
                }
            }

            @Override
            public void onError(Throwable e) {
                if(listener != null){
                    listener.onError(e);
                }
            }

            @Override
            public void onComplete() {

            }
        };
        ob.subscribe(disposableObserver);
        return disposableObserver;
    }
}
