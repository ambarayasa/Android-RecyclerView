package com.example.gamesteam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView judul, desc;

    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        judul = findViewById(R.id.judul);
        desc = findViewById(R.id.desc);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("images") || getIntent().hasExtra("data1") ||
                getIntent().hasExtra("data2")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images", 1);

        }else{
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){
        judul.setText(data1);
        desc.setText(data2);
        mainImageView.setImageResource(images);

    }

}