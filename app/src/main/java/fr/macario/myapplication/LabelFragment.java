package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentLabelBinding;
import fr.macario.myapplication.databinding.FragmentProfilBinding;


public class LabelFragment extends Fragment {

    private FragmentLabelBinding binding;
    public LabelFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLabelBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}