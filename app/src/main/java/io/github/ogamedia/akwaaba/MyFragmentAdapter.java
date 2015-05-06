package io.github.ogamedia.akwaaba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ogamedia on 5/2/15.
 */
public class MyFragmentAdapter extends RecyclerView.Adapter<MyFragmentAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private String[] mDirectoryInstitution;
    private String[] mDirectoryPhoneNumber;
    private String mNumber;

    private ClickListener clickListener;
    private Caller caller;
    private Context mContext;

    public MyFragmentAdapter(Context context, String[] directoryInstitution, String[] directoryPhoneNumber) {
        mDirectoryInstitution = directoryInstitution;
        mDirectoryPhoneNumber = directoryPhoneNumber;
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
        public TextView tv2;
        private ClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.dirInst);
            tv2 = (TextView) itemView.findViewById(R.id.dirPhone);
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

        public void setClickListener(ClickListener clickListener) {
            this.clickListener = clickListener;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_item, parent, false);
        ViewHolder vh;
        vh = new ViewHolder(rowView);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
       viewHolder.tv1.setText(mDirectoryInstitution[position]);
       viewHolder.tv2.setText(mDirectoryPhoneNumber[position]);
         ;

                viewHolder.setClickListener(new ClickListener(){

           @Override
           public void onClick(View v, int position, boolean isLongClick) {
               String pos = String.valueOf(v);

               if(isLongClick) {

               } else {
//                in case i need it for single clicks
                   mNumber = mDirectoryPhoneNumber[position];
//                   passing the intent to the call class was the problem
                   caller = new Caller(mContext, mNumber);
               }
           }
       });
    }


    @Override
    public int getItemCount() {
        return mDirectoryInstitution.length;
    }

    /* Interface for handling clicks - both normal and long ones. */
    public interface ClickListener {

       /**
         * Called when the view is clicked.
         *
         * @param v view that is clicked
         * @param position of the clicked item
         * @param isLongClick true if long click, false otherwise
         */
        public void onClick(View v, int position, boolean isLongClick);

    }


}
