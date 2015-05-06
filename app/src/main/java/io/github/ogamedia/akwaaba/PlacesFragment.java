package io.github.ogamedia.akwaaba;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;

/**
 * Created by ogamedia on 4/30/15.
 */
public class PlacesFragment extends Fragment {
    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context;
    GridView gv;


    private static String[] placeTitle;
    private static int [] placePicMain = {R.drawable.adomi_1, R.drawable.adum_1, R.drawable.ind_arch_1, R.drawable.kakum_2};
    private static int [] placePicTwo = {R.drawable.adomi_3, R.drawable.ic_launcher, R.drawable.ind_arch_2, R.drawable.kakum_1};
    private static int [] placePicThird = {R.drawable.adomi_1, R.drawable.ic_launcher, R.drawable.ind_arch_4, R.drawable.ic_launcher};


    public PlacesFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);
        FragmentActivity cc = (FragmentActivity) getActivity();

//        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
//        mLayoutManager = new LinearLayoutManager(cc);
//        mRecyclerView.setLayoutManager(mLayoutManager);

        gv=(GridView) rootView.findViewById(R.id.gridView1);

        context = getActivity();
        placeTitle = getResources().getStringArray(R.array.place_names);

//        mRecyclerView.setAdapter(new CardFragmentAdapter(context, placeTitle,placePicMain, placePicTwo, placePicThird));
        gv.setAdapter(new MyAdapter(context, placeTitle, placePicMain, placePicTwo, placePicThird));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}
