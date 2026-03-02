package com.example.media;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    String[] pays = {
            "🇩🇿 Algérie",
            "🇫🇷 France",
            "🇲🇦 Maroc",
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
            "🇳🇱 Pays-Bas",
            "🇧🇪 Belgique",
            "🇨🇭 Suisse",
            "🇸🇪 Suède",
            "🇳🇴 Norvège",
            "🇩🇰 Danemark",
            "🇫🇮 Finlande",
            "🇵🇱 Pologne",
            "🇬🇷 Grèce",
            "🇮🇩 Indonésie",
            "🇵🇰 Pakistan",
            "🇧🇩 Bangladesh",
            "🇵🇭 Philippines",
            "🇻🇳 Vietnam",
            "🇺🇦 Ukraine"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pays));
    }
}