package io.github.ogamedia.akwaaba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ogamedia on 5/3/15.
 */
public class SlideFragment extends android.support.v4.app.Fragment {
    private static final String ARG_KEY = "page";
    private int mPageNumber;

    public static SlideFragment create(int pageNumber){
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_KEY, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SlideFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPageNumber = getArguments().getInt(ARG_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_directory, container, false);
        return  rootView;
    }

    public int getPageNumber() {
        return mPageNumber;
    }
}
