package fr.macario.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import fr.macario.myapplication.databinding.FragmentPrefAlimentairesBinding;


public class PrefAlimentairesFragment extends Fragment {

    private FragmentPrefAlimentairesBinding binding;
    public PrefAlimentairesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPrefAlimentairesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backprefalimantaire.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ProfilFragment profileFragment = new ProfilFragment();
            fragmentTransaction.add(R.id.fragment_container_view, profileFragment);
            fragmentTransaction.commit();
        });

        binding.QualiteNutritionnellechevron.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            qualite_nutritionnelleFragment qualiteNutritionnelleFragment = new qualite_nutritionnelleFragment();
            fragmentTransaction.add(R.id.fragment_container_view, qualiteNutritionnelleFragment);
            fragmentTransaction.commit();
        });

        binding.ingredientschevron.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ingredientFragment ingredientFragment = new ingredientFragment();
            fragmentTransaction.add(R.id.fragment_container_view, ingredientFragment);
            fragmentTransaction.commit();
        });

        binding.transfoalimentchevron.setOnClickListener(v -> {

        });

        binding.labelchevron.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            LabelFragment labelFragment = new LabelFragment();
            fragmentTransaction.add(R.id.fragment_container_view, labelFragment);
            fragmentTransaction.commit();
        });


    }
}