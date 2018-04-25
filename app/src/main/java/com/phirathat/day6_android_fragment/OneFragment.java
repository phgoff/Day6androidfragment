package com.phirathat.day6_android_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    private static OneFragment fragment;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String value = getArguments().getString("KEY");
        Toast.makeText( getActivity() , value, Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);

    }

    public static Fragment newInstance(String value) {
        if ( fragment == null )
            fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", value);
        fragment.setArguments(bundle);
        return fragment;

    }
}