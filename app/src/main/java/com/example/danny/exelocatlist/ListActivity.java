package com.example.danny.exelocatlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listMarks);

        Location location = new Location();

        final List<Location> listMarks = location.getLoactionList();
        final List<String> listNames = new ArrayList<>();

        for (Location l: listMarks) {
            listNames.add(l.getName());
        }

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNames);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listNames.get(position).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}