package com.example.oranmoshe.finalmobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class TasksList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser.recycle";
    private ArrayList<TaskItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.cardList);



        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        items = new ArrayList<TaskItem>();
        generateTasks();
        mAdapter = new RecycleAdapterManager(items);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void generateTasks(){
        items.add(new TaskItem("Task1"));
        items.add(new TaskItem("Task2"));
        items.add(new TaskItem("Task3"));
        items.add(new TaskItem("Task4"));
        items.add(new TaskItem("Task5"));
        items.add(new TaskItem("Task6"));
        items.add(new TaskItem("Task7"));
    }

    public void goToCreateTasks(View v){
        Intent intent = new Intent(this, CreateNewTask.class);
        startActivity(intent);
    }
}
