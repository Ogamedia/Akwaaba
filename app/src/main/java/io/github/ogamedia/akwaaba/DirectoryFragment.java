package io.github.ogamedia.akwaaba;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by ogamedia on 4/30/15.
 */
public class DirectoryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] directoryInstitution;
    private String[] directoryPhoneNumber;
    private Context context;


    public DirectoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directory, container, false);

        final FragmentActivity c = (FragmentActivity) getActivity();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(c);
        mRecyclerView.setLayoutManager(mLayoutManager);



//        mRecyclerView.setHasFixedSize(true);

        directoryInstitution = getResources().getStringArray(R.array.emergency_institution);
        directoryPhoneNumber = getResources().getStringArray(R.array.emergency_number);
        context = getActivity();

        mAdapter = new MyFragmentAdapter(context, directoryInstitution, directoryPhoneNumber);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
