package com.tz.practice0818;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_main;
    List<Item> list;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb_main = findViewById(R.id.tb_main);
        setSupportActionBar(tb_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        initList();
        rv_main = findViewById(R.id.rv_main);
        adapter = new ItemAdapter(this, list);
        rv_main.setAdapter(adapter);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it1:
                Toast.makeText(this, "it1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it2:
                Toast.makeText(this, "it2", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    public void initList(){
        list = new ArrayList<>();
        for(int i=0;i<20;i++){
            Item item = new Item();
            item.setId(i);
            item.setContent("This is content :" + i);
            list.add(item);
        }
    }

}
