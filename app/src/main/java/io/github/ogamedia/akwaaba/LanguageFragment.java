package io.github.ogamedia.akwaaba;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ogamedia on 4/30/15.
 */
public class    LanguageFragment extends Fragment {

    public LanguageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_language, container, false);
        return rootView;
    }
}
