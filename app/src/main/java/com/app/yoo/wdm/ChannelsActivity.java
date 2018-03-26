package com.app.yoo.wdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ChannelsActivity extends AppCompatActivity {

    private Spinner sp_item,sp_value;
    private ListView lv_channels;
    //private ArrayList<String> spinnerItem,spinnerValue;
    private ArrayAdapter<String> adapterItem,adapterValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channels);
        findView();
        setListener();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.more, menu);  //初始化加载菜单项

        //menu.add(1, Menu.FIRST, 1, "Change Site ID");   //四个参数，groupid, itemid, orderid, title
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.addChannel:            //Menu.FIRST对应itemid为1
                //Toast.makeText(ChannelsActivity.this, "more", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChannelsActivity.this,AddChannelActivity.class);
                startActivityForResult(intent,1);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1){
            if(data != null) {
                String result = data.getExtras().getString("result");
                Log.i("onActivityResult", result);
            }
        }
    }

    public void findView(){
        sp_item = findViewById(R.id.spinner_item);
        sp_value = findViewById(R.id.spinner_value);
        lv_channels = findViewById(R.id.lv_channles);

    }

    public void setListener(){
        sp_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)sp_item.getSelectedItem();
                String[] mValues = null;
                if(str.equals("系统")){
                    mValues = getResources().getStringArray(R.array.system);
                }else if(str.equals("网元")){
                    mValues = getResources().getStringArray(R.array.ne);
                }else if(str.equals("区域")){
                    mValues = getResources().getStringArray(R.array.area);
                }
                adapterValue = new ArrayAdapter<String>(ChannelsActivity.this,android.R.layout.simple_spinner_item,mValues);
                adapterValue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_value.setAdapter(adapterValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
