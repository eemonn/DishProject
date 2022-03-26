package comp3350.dishproject.presentation;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private Context mContext;
    private List<HomeCard> mData;

    /*
    Input: Takes in a context and a list of home cards
    Output: Constructor
    Description: Constructor
    */
    public Adapter(Context mContext, List<HomeCard> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    /*
   Input: ViewGroup parent, Int viewType
   Output: returns View Holder
   Description: The method creates and initializes a ViewHolder and its associated view. Does not
   fill contents
    */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.card_item,parent, false);
        return new myViewHolder(v);
    }

    /*
   Input: a viewHolder
   Output: void function
   Description: This method will associate a ViewHolder with its data.
    */
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.background_img.setImageResource(mData.get(position).getBackground());

        holder.tv_title.setText(mData.get(position).getRecipeName());
        holder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ViewRecipe.class);
                intent.putExtra("search",mData.get(position).getRecipeName().toLowerCase());
                mContext.startActivity(intent);
            }
        });
    }

    /*
   Description: This method gets the size of the data set
    */
    @Override
    public int getItemCount() {
        return mData.size();
    }


    //Used in conjunction with the home cards to display them
    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView background_img;
        TextView tv_title;
        Button btn_view;

        /*
          Input: Takes in a View object
          Output: Constructor
          Description: Constructor for the view holder
        */
        public myViewHolder (View itemView) {
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            tv_title = itemView.findViewById(R.id.card_title);
            btn_view = itemView.findViewById(R.id.btn_view);
        }
    }
}//Adapter
