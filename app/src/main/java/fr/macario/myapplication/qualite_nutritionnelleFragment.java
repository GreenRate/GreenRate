package fr.macario.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQualiteNutritionnelleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();

        binding.backprefalimantaire.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
            fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
            fragmentTransaction.commit();
        });

        binding.pasimportantqualiteenutritionnelle.setOnClickListener(v -> {
            Bonnequal = 0;

            binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("Bonnequal", Bonnequal);
            editor.apply();
        });

        binding.importantqualiteenutritionnelle.setOnClickListener(v -> {
            Bonnequal = 1;

            binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("Bonnequal", Bonnequal);
            editor.apply();
        });

        binding.obligatoirequaliteenutritionnelle.setOnClickListener(v -> {
            Bonnequal = 2;

            binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("Bonnequal", Bonnequal);
            editor.apply();
        });

        binding.pasimportantmatiereqrasse.setOnClickListener(v -> {
            faibleQuantMatiereGrasse = 0;

            binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("faibleQuantMatiereGrasse", faibleQuantMatiereGrasse);
            editor.apply();
        });

        binding.importantmatiereqrasse.setOnClickListener(v -> {
            faibleQuantMatiereGrasse = 1;

            binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("faibleQuantMatiereGrasse", faibleQuantMatiereGrasse);
            editor.apply();
        });

        binding.obligatoirematiereqrasse.setOnClickListener(v -> {
            faibleQuantMatiereGrasse = 2;

            binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("faibleQuantMatiereGrasse", faibleQuantMatiereGrasse);
            editor.apply();
        });

        binding.pasimportantsel.setOnClickListener(v -> {
            quantSel = 0;

            binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantSel", quantSel);
            editor.apply();
        });

        binding.importantsel.setOnClickListener(v -> {
            quantSel = 1;

            binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantSel", quantSel);
            editor.apply();
        });

        binding.obligatoiresel.setOnClickListener(v -> {
            quantSel = 2;

            binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("quantSel", quantSel);
            editor.apply();
        });

        binding.pasimportantsucre.setOnClickListener(v -> {
            quantSucre = 0;

            binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantSucre", quantSucre);
            editor.apply();
        });

        binding.importantsucre.setOnClickListener(v -> {
            quantSucre = 1;

            binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantSucre", quantSucre);
            editor.apply();
        });

        binding.obligatoiresucre.setOnClickListener(v -> {
            quantSucre = 2;

            binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("quantSucre", quantSucre);
            editor.apply();
        });

        binding.pasimportantgras.setOnClickListener(v -> {
            quantAcide = 0;

            binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantAcide", quantAcide);
            editor.apply();
        });

        binding.importantgras.setOnClickListener(v -> {
            quantAcide = 1;

            binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("quantAcide", quantAcide);
            editor.apply();
        });

        binding.obligatoiregras.setOnClickListener(v -> {
            quantAcide = 2;

            binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("quantAcide", quantAcide);
            editor.apply();
        });

        switch (preferences.getInt("Bonnequal", -1)) {
            case 0 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
        }

        switch (preferences.getInt("faibleQuantMatiereGrasse", -1)){
            case 0 :
                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
        }

        switch (preferences.getInt("quantSel", -1)) {
            case 0 :
                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
        }

        switch (preferences.getInt("quantSucre", -1)){
            case 0:
                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            case -1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
        }

        switch (preferences.getInt("quantAcide", -1)) {
            case 0 :
                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
        }
    }

    public int getBonnequal() {return Bonnequal;}
    public int getFaibleQuantMatiereGrasse() {return faibleQuantMatiereGrasse;}
    public int getQuantAcide() {return quantAcide;}
    public int getQuantSel() {return quantSel;}
    public int getQuantSucre() {return quantSucre;}
}