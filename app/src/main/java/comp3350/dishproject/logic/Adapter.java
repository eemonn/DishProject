package comp3350.dishproject.logic;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.dishproject.R;
import comp3350.dishproject.application.MainActivity;
import comp3350.dishproject.presentation.ViewRecipe;
import comp3350.dishproject.presentation.item;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;
    List<item> mData;

    public Adapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.card_item,parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.tv_title.setText(mData.get(position).getRecipeName());
        holder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String log = "This is a button with title " + mData.get(position).getRecipeName();
                Intent intent= new Intent(mContext,ViewRecipe.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView background_img;
        TextView tv_title;
        Button btn_view;

        public myViewHolder (View itemView) {
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            tv_title = itemView.findViewById(R.id.card_title);
            btn_view = itemView.findViewById(R.id.btn_view);
        }
    }
}
