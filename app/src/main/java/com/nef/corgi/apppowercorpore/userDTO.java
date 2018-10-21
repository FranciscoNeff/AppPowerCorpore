package com.nef.corgi.apppowercorpore;

public class userDTO {
    private String user_name;
    private String email_user;
    private String pass;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public userDTO(String user_name, String email_user, String pass) {
        this.user_name = user_name;
        this.email_user = email_user;
        this.pass = pass;
    }
    public userDTO(){
        user_name="name";
        email_user="email";
        pass="1234";
    }
}
