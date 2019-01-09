package com.example.a12541.homework;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView manager_time_v,manager_place_v,manager_content_v,manager_receiver_v;
    private ImageView title_back;
    private EditText manager_receiver_edit_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        setFont();

        //返回事件
        title_back = (ImageView)findViewById(R.id.manager_title_back);
        title_back.setOnClickListener(this);
        //给“接收人”设置click事件
        manager_receiver_edit_v = (EditText)findViewById(R.id.manager_receiver_edit);
        manager_receiver_edit_v.setFocusable(false);
        manager_receiver_edit_v.setOnClickListener(this);
    }

    private void setFont(){
        manager_time_v = (TextView)findViewById(R.id.manager_time);
        manager_place_v = (TextView)findViewById(R.id.manager_place);
        manager_content_v = (TextView)findViewById(R.id.manager_content);
        manager_receiver_v = (TextView) findViewById(R.id.manager_receiver);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"华文行楷.ttf");
        manager_time_v.setTypeface(typeface);
        manager_place_v.setTypeface(typeface);
        manager_content_v.setTypeface(typeface);
        manager_receiver_v.setTypeface(typeface);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.manager_title_back:
                finish();
                break;
            case R.id.manager_receiver_edit:
                break;
            default:
                break;
        }
    }

}
