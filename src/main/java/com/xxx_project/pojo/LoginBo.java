package com.xxx_project.pojo;

public class LoginBo {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginBo{" +
                "code='" + code + '\'' +
                '}';
    }
}
