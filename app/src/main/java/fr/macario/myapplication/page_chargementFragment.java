package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class page_chargementFragment extends Fragment {

    public page_chargementFragment() {
        // Required empty public constructor
    }

    public static page_chargementFragment newInstance(String param1, String param2) {
        page_chargementFragment fragment = new page_chargementFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_chargement, container, false);
    }
}