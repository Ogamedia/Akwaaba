package io.github.ogamedia.akwaaba;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ogamedia on 4/30/15.
 */
public class PeopleFragment extends Fragment {

    public PeopleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);
        return rootView;
    }
}
