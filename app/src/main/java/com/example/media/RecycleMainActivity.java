package com.example.media;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAjouter;
    List<Ville> villeList;
    VilleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAjouter = findViewById(R.id.btnAjouter);

        villeList = new ArrayList<>();
        villeList.add(new Ville("Casablanca"));
        villeList.add(new Ville("Rabat"));
        villeList.add(new Ville("Marrakech"));
        villeList.add(new Ville("Fès"));

        adapter = new VilleAdapter(this, villeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAjouter.setOnClickListener(v -> {
            EditText editText = new EditText(this);

            new AlertDialog.Builder(this)
                    .setTitle("Ajouter une ville")
                    .setView(editText)
                    .setPositiveButton("Ajouter", (dialog, which) -> {
                        String nom = editText.getText().toString();
                        villeList.add(new Ville(nom));
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Annuler", null)
                    .show();
        });
    }
}