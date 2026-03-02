package com.example.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imgChat, imgChien;
    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgChat = findViewById(R.id.imageView);
        imgChien = findViewById(R.id.imageView2);

        imgChat.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "coco chat", Toast.LENGTH_SHORT).show();
            media = MediaPlayer.create(getApplicationContext(),R.raw.chat);
            media.start();
        });

        imgChien.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "coco chien", Toast.LENGTH_SHORT).show();
            media = MediaPlayer.create(getApplicationContext(),R.raw.chien);
            media.start();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}