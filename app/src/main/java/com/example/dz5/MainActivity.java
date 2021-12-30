package com.example.dz5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private ArrayList<Model> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFlags();
        initRv();
        setClick();
    }

    private void setClick() {
        adapter.setOnClick(model -> {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("key", model.getId());
            startActivity(intent);

        });
    }

    private void initRv() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter();
        adapter.setArrayList(arrayList);
        recyclerView.setAdapter(adapter);


    }

    private void createFlags() {
        arrayList = new ArrayList<>();
        arrayList.add(new Model(R.drawable.eurasia, "Eurasia", 1));
        arrayList.add(new Model(R.drawable.ic_africa, "Africa", 2));
        arrayList.add(new Model(R.drawable.ic_cna_3x, "North America", 3));
        arrayList.add(new Model(R.drawable.ic_csa_3x, "South America", 4));
        arrayList.add(new Model(R.drawable.ic_au_3x, "Australia", 5));
    }

}