package com.ssycloud.ssyredis.pojo;

import java.io.Serializable;

/**
 * @ClassName
 * @Description //TODO $
 * @Date $ $
 **/
public class User implements Serializable {
    private String name;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
