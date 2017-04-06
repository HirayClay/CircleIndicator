package com.example.widget.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.widget.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CyanPage extends Fragment {


    public CyanPage() {
        // Required empty public constructor
    }

    public static CyanPage newInstance() {
        
        Bundle args = new Bundle();
        
        CyanPage fragment = new CyanPage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cyan_page, container, false);
    }

}
