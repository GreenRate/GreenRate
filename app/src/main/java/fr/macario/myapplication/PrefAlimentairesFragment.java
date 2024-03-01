package fr.macario.myapplication;

import android.os.Bundle;

import androidx.constraintlayout.helper.widget.Layer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentPrefAlimentairesBinding;
import fr.macario.myapplication.databinding.FragmentProfilBinding;


public class PrefAlimentairesFragment extends Fragment {

    private FragmentPrefAlimentairesBinding binding;
    public PrefAlimentairesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPrefAlimentairesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backprefalimantaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ProfilFragment profileFragment = new ProfilFragment();
                fragmentTransaction.add(R.id.fragment_container_view, profileFragment);
                fragmentTransaction.commit();
            }
        });

        binding.QualiteNutritionnellechevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                qualite_nutritionnelleFragment qualiteNutritionnelleFragment = new qualite_nutritionnelleFragment();
                fragmentTransaction.add(R.id.fragment_container_view, qualiteNutritionnelleFragment);
                fragmentTransaction.commit();
            }
        });

        binding.ingredientschevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ingredientFragment ingredientFragment = new ingredientFragment();
                fragmentTransaction.add(R.id.fragment_container_view, ingredientFragment);
                fragmentTransaction.commit();
            }
        });

        binding.transfoalimentchevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.labelchevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LabelFragment labelFragment = new LabelFragment();
                fragmentTransaction.add(R.id.fragment_container_view, labelFragment);
                fragmentTransaction.commit();
            }
        });


    }
}