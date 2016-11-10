package io.github.seemuch.coordinatorlayoutexperiment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> users = new ArrayList<>();
        users.add("1");
        users.add("2");
        users.add("3");
        users.add("4");
        users.add("5");
        users.add("6");
        users.add("7");
        users.add("8");
        users.add("9");
        users.add("10");
        users.add("11");
        users.add("12");

        MyAdapter adapter = new MyAdapter(users);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
