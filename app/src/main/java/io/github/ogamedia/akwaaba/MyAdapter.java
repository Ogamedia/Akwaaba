package io.github.ogamedia.akwaaba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ogamedia on 5/4/15.
 */
public class MyAdapter extends BaseAdapter {
    private String[] Title;
    private int[] pic1;
    private int[] pic2;
    private int[] pic3;
    Context mContext;

    private static LayoutInflater inflater=null;

    public MyAdapter(Context context, String[] placeTitle, int[] placePicMain, int[] placePicTwo, int[] placePicThird) {
        Title = placeTitle;
        pic1 = placePicMain;
        pic2 = placePicTwo;
        pic3 = placePicThird;
        mContext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public class Holder {
        TextView tv;
        ImageView img1;
        ImageView img2;
        ImageView img3;
    }

    @Override
    public int getCount() {
        return Title.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.places_card_item, null);
              holder.tv = (TextView) rowView.findViewById(R.id.textView8);
            holder.img1 = (ImageView) rowView.findViewById(R.id.imMain);
            holder.img2 = (ImageView) rowView.findViewById(R.id.imPic2);
            holder.img3 = (ImageView) rowView.findViewById(R.id.imPic3);

        holder.tv.setText(Title[position]);
        holder.img1.setImageResource(pic1[position]);
        holder.img2.setImageResource(pic2[position]);
        holder.img3.setImageResource(pic3[position]);

        return rowView;
    }
}
