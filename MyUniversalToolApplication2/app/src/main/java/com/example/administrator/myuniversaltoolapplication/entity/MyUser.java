package com.example.administrator.myuniversaltoolapplication.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2016/1/16.
 */
public class MyUser extends BmobUser {

    private Integer sex;
    private BmobFile avater;

    public BmobFile getAvater() {
        return avater;
    }

    public void setAvater(BmobFile avater) {
        this.avater = avater;
    }

  /*  private String img_avater;

    public String getImg_avater() {
        return img_avater;
    }

    public void setImg_avater(String img_avater) {
        this.img_avater = img_avater;
    }*/

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
