package com.example.kmj.warmpot_2018stac.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kmj.warmpot_2018stac.R;


public class SpeakFragment extends Fragment {
    public static SpeakFragment newInstance() {
        SpeakFragment fragment = new SpeakFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_speak, container, false);
    }
}
