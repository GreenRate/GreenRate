package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentPrefAlimentairesBinding;
import fr.macario.myapplication.databinding.FragmentQualiteNutritionnelleBinding;


public class qualite_nutritionnelleFragment extends Fragment {

    private FragmentQualiteNutritionnelleBinding binding;

    public qualite_nutritionnelleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQualiteNutritionnelleBinding.inflate(inflater, container, false);
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
                PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
                fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
                fragmentTransaction.commit();
            }
        });
    }
}