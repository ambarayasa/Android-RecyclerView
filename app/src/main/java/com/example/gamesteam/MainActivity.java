package com.example.gamesteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.dota, R.drawable.csgo, R.drawable.pubg, R.drawable.gta5, R.drawable.brawhala, R.drawable.overwatch, R.drawable.persona5, R.drawable.paladins};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.game_steam);
        s2 = getResources().getStringArray(R.array.deskripsi);

        AdapterData adapterData = new AdapterData(this, s1, s2, images);
        recyclerView.setAdapter(adapterData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}