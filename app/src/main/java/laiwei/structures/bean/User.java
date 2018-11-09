package laiwei.structures.bean;

import laiwei.structures.retrofit.converter.DataConverter;

/**
 * Created by laiwei on 2018/11/7 0007.
 */
public class User implements DataConverter{
    String name;
    int id;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Object getData() {
        return this;
    }
}
