package com.xxx_project.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String openid;
    private String picUrl = "";
    private String nickname = "";
//
//    User(String openid,String picUrl,String nickname){
//        this.openid = openid;
//        this.picUrl = picUrl;
//        this.nickname = nickname;
//    }

    @Override
    public String toString() {
        return "User{" +
                "openid='" + openid + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
