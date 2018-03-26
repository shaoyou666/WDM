package com.app.yoo.wdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_userinfo;
    private Button bt_topology,bt_channels;
    private MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        myApp = (MyApp)getApplication();
        String username = myApp.getUsername();
        tv_userinfo.setText("欢迎您，" + username);
        bt_channels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChannelsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void findView(){
        tv_userinfo = findViewById(R.id.tv_userinfo);
        bt_channels = findViewById(R.id.bt_channels);
        bt_topology = findViewById(R.id.bt_topology);
    }
}
