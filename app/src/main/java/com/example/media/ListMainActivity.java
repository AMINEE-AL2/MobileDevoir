package com.example.media;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListMainActivity extends AppCompatActivity {
    Button btnList, btnGrid, btnSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnList = findViewById(R.id.btnList);
        btnGrid = findViewById(R.id.btnGrid);
        btnSpinner = findViewById(R.id.btnSpinner);

        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(ListMainActivity.this,ListActivity.class);
            startActivity(intent);
        });
        btnGrid.setOnClickListener(v -> {
            Intent intent = new Intent(ListMainActivity.this,ListActivity.class);
            startActivity(intent);
        });
        btnSpinner.setOnClickListener(v -> {
            Intent intent = new Intent(ListMainActivity.this,ListActivity.class);
            startActivity(intent);
        });
    }
}