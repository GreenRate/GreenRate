package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentPrefAlimentairesBinding;
import fr.macario.myapplication.databinding.FragmentQualiteNutritionnelleBinding;


public class qualite_nutritionnelleFragment extends Fragment {


    private FragmentQualiteNutritionnelleBinding binding;
    public qualite_nutritionnelleFragment() {}

    public int Bonnequal;
    public int faibleQuantMatiereGrasse;
    public int quantSel;
    public int quantSucre;
    public int quantAcide;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        binding.pasimportantqualiteenutritionnelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bonnequal = 0;

                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });
    }
}