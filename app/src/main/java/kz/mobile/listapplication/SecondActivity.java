package kz.mobile.listapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewPersonName = findViewById(R.id.textViewPersonName);

        String personName = getIntent().getStringExtra("person_name");
        textViewPersonName.setText(personName);
    }
}
