package com.example.gamis214.expandablelayout_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.ExpandableWeightLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lstNumbers = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lstNumbers.add("A");
        lstNumbers.add("B");
        lstNumbers.add("C");
        lstNumbers.add("D");
        lstNumbers.add("E");

        adapter adater = new adapter(lstNumbers);
        recyclerView.swapAdapter(adater,true);
    }
}
