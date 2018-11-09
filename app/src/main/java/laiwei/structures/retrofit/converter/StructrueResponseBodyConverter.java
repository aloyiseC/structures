package laiwei.structures.retrofit.converter;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import laiwei.structures.retrofit.bean.HttpResult;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by laiwei on 2017/10/12 0012.
 */
public class StructrueResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;
    private final Class<? extends DataConverter> typeClazz;

    public StructrueResponseBodyConverter(Gson gson, Type type, Class<? extends DataConverter> typeClazz) {
        this.gson = gson;
        this.type = type;
        this.typeClazz = typeClazz;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        HttpResult resultResponse = gson.fromJson(response,type);
        if(typeClazz != null){
            String dataJson = gson.toJson(resultResponse.getData());
            DataConverter dataConverter = gson.fromJson(dataJson,typeClazz);
            resultResponse.setData(dataConverter.getData());
        }
        return (T) resultResponse;
    }
}
