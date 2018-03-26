package com.app.yoo.wdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddChannelActivity extends AppCompatActivity {

    private Spinner sp_neA,sp_neZ,sp_system;
    private EditText et_CircuitCode,et_channelNum;
    private Button bt_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_channel);
        findView();
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result","OK");
                AddChannelActivity.this.setResult(RESULT_OK,intent);
                AddChannelActivity.this.finish();
            }
        });
    }
    public void findView(){
        sp_neA = findViewById(R.id.sp_neA);
        sp_neZ = findViewById(R.id.sp_neZ);
        sp_system = findViewById(R.id.sp_system);
        et_channelNum = findViewById(R.id.et_channelNum);
        et_CircuitCode = findViewById(R.id.et_CircuitCode);
        bt_save = findViewById(R.id.bt_save);

    }
}
