package com.example.a12541.homework;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ReceiverActivity extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;
    private List<Note> notes = new ArrayList<>();
    private String[] noteContent = {"这是第1个任务卡","这是第2个任务卡","这是第3个任务卡","这是第4个任务卡",
            "这是第5个任务卡","这是第6个任务卡","这是第7个任务卡","这是第8个任务卡","这是第9个任务卡",
            "这是第10个任务卡","这是第11个任务卡","这是第12个任务卡","这是第13个任务卡", "这是第14个任务卡",
            "这是第15个任务卡","这是第16个任务卡","这是第17个任务卡","这是第18个任务卡","这是第19个任务卡","这是第20个任务卡"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        //设置toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.receiver_toolbar);
        setSupportActionBar(toolbar);

        //设置滑动页面的system_menu图标
        mDrawerLayout = (DrawerLayout)findViewById(R.id.receiver_drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.plus);
        }

        //美化滑动界面
        NavigationView navigationView = (NavigationView)findViewById(R.id.receiver_nav_view);
        navigationView.setCheckedItem(R.id.receiver_slip_exit);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        //做recycleView
        initNote();
        initRecycleView();

    }
    private void initNote(){
        for(int i=0;i<noteContent.length;i++){
            Note note = new Note(noteContent[i]);
            notes.add(note);
        }
    }
    private void initRecycleView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.receiver_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NoteAdapter adapter = new NoteAdapter(notes);
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_send_msg:
                Intent intent = new Intent(ReceiverActivity.this,ManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.toolbar_exit:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

}
