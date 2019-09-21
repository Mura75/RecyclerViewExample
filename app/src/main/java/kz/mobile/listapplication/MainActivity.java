package kz.mobile.listapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MainAdapter mainAdapter;

    private MainAdapter.ItemClickListener itemClickListener = new MainAdapter.ItemClickListener() {
        @Override
        public void onItemClick(String item, int position) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("person_name", item);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add("Person " + i);
        }

        mainAdapter = new MainAdapter(persons, itemClickListener);
        recyclerView.setAdapter(mainAdapter);
    }
}
