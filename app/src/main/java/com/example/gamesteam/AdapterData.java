 package com.example.gamesteam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    String data1[], data2[];
    int images[];
    Context context;

    public AdapterData(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.game_steam_txt.setText(data1[position]);
        holder.deskripsi_txt.setText(data2[position]);
        holder.image_img.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("images", images[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView game_steam_txt, deskripsi_txt;
        ImageView image_img;
        ConstraintLayout mainLayout;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            game_steam_txt = itemView.findViewById(R.id.game_steam_txt);
            deskripsi_txt = itemView.findViewById(R.id.deskripsi_txt);
            image_img = itemView.findViewById(R.id.image_img);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
