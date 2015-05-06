package io.github.ogamedia.akwaaba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
* Created by ogamedia on 5/3/15.
*/
public class CardFragmentAdapter extends RecyclerView.Adapter<CardFragmentAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private String[] Title;
    private int[] pic1;
    private int[] pic2;
    private int[] pic3;
    Context mContext;


    public CardFragmentAdapter(Context context, String[] placeTitle, int[] placePicMain, int[] placePicTwo, int[] placePicThird) {
        Title = placeTitle;
        pic1 = placePicMain;
        pic2 = placePicTwo;
        pic3 = placePicThird;
        mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView tv1;
        public ImageView imageView1, imageView2, imageView3;
        private MyFragmentAdapter.ClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.textView8);
            imageView1 = (ImageView) itemView.findViewById(R.id.imMain);
            imageView2 = (ImageView) itemView.findViewById(R.id.imPic2);
            imageView3 = (ImageView) itemView.findViewById(R.id.imPic3);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }

        public void setClickListener(MyFragmentAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_card_item, parent, false);
        ViewHolder vh;
        vh = new ViewHolder(rowView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv1.setText(Title[position]);
        viewHolder.imageView1.setImageResource(pic1[position]);
        viewHolder.imageView2.setImageResource(pic2[position]);
        viewHolder.imageView3.setImageResource(pic3[position]);

    }

    @Override
    public int getItemCount() {
        return Title.length;
    }
}
