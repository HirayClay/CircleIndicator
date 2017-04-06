package com.example.widget.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.widget.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccentPage extends Fragment {


    public AccentPage() {
        // Required empty public constructor
    }

    public static AccentPage newInstance() {

        Bundle args = new Bundle();

        AccentPage fragment = new AccentPage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accent_page, container, false);
    }

}
