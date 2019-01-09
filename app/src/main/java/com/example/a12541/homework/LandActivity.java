package com.example.a12541.homework;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LandActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView password_v,user_name_v,sign_in_v,sign_up_v;
    private EditText password_edit_v,user_name_edit_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);

        //把字体设置为华文行楷
        setFont();
    }

    private void setFont(){
        password_v = (TextView)findViewById(R.id.password);
        user_name_v = (TextView)findViewById(R.id.user_name);
        sign_in_v = (TextView)findViewById(R.id.sign_in);
        sign_up_v = (TextView)findViewById(R.id.sign_up);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"华文行楷.ttf");
        password_v.setTypeface(typeface);
        user_name_v.setTypeface(typeface);
        sign_up_v.setTypeface(typeface);
        sign_in_v.setTypeface(typeface);

        sign_in_v.setOnClickListener(this);
        password_edit_v = (EditText)findViewById(R.id.password_edit);
        user_name_edit_v = (EditText)findViewById(R.id.user_name_edit);
    }

    @Override
    public void onClick(View v){
        String password = password_edit_v.getText().toString();
        String name = user_name_edit_v.getText().toString();
        if(password.equals("admin")&&name.equals("admin")){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            //进入主界面
            Intent intent = new Intent(LandActivity.this,ReceiverActivity.class);
            startActivity(intent);
        }
    }

}
