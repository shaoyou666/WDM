package com.app.yoo.wdm;

import android.app.Application;

/**
 * Created by csyoo on 2018/3/22.
 */

public class MyApp extends Application {
    private String username = null;

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

}
