package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentIngredientBinding;
import fr.macario.myapplication.databinding.FragmentProfilBinding;

public class ingredientFragment extends Fragment {

    private FragmentIngredientBinding binding;
    public ingredientFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIngredientBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}