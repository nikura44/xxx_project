package com.xxx_project.pojo;

public class Back {
    private String token;

    private User user;

    private boolean statue;

    public boolean isStatue() {
        return statue;
    }

    public void setStatue(boolean statue) {
        this.statue = statue;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Back{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
