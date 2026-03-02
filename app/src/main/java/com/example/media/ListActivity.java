package com.example.media;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {
    String[] pays = {
            "🇲🇦 Maroc",
            "🇫🇷 France",
            "🇹🇳 Tunisie",
            "🇪🇬 Égypte",
            "🇸🇦 Arabie Saoudite",
            "🇩🇪 Allemagne",
            "🇺🇸 États-Unis",
            "🇨🇳 Chine",
            "🇯🇵 Japon",
            "🇧🇷 Brésil",
            "🇮🇳 Inde",
            "🇷🇺 Russie",
            "🇮🇹 Italie",
            "🇪🇸 Espagne",
            "🇬🇧 Royaume-Uni",
            "🇨🇦 Canada",
            "🇦🇺 Australie",
            "🇲🇽 Mexique",
            "🇹🇷 Turquie",
            "🇰🇷 Corée du Sud",
            "🇳🇬 Nigeria",
            "🇿🇦 Afrique du Sud",
            "🇦🇷 Argentine",
            "🇵🇹 Portugal",
            "🇩🇿 Algérie"
    };
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.listView);

        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pays));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paysSelectionne = pays[position];
                Toast.makeText(getApplicationContext(), "Pays sélectionné : " + paysSelectionne, Toast.LENGTH_SHORT).show();
            }
        });
    }
}