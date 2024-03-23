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

import fr.macario.myapplication.databinding.FragmentIngredientBinding;

public class ingredientFragment extends Fragment {

    private FragmentIngredientBinding binding;
    public ingredientFragment() {}

    public int vegan;
    public int vegetarien;
    public int gluten;



    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIngredientBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();

        binding.backingredient.setOnClickListener(v -> {
            binding.pasimportantvegan.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
            fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
            fragmentTransaction.commit();
        });

        binding.pasimportantvegan.setOnClickListener(v -> {
            vegan = 0;

            binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("vegan", vegan);
            editor.apply();
        });

        binding.importantvegan.setOnClickListener(v -> {
            vegan = 1;

            binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("vegan", vegan);
            editor.apply();
        });

        binding.obligatoirevegan.setOnClickListener(v -> {
            vegan = 2;

            binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("vegan", vegan);
            editor.apply();
        });

        binding.pasimportantvegetarien.setOnClickListener(v -> {
            vegetarien = 0;

            binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("vegetarien", vegetarien);
            editor.apply();
        });

        binding.importantvegetarien.setOnClickListener(v -> {
            vegetarien = 1;

            binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("vegetarien", vegetarien);
            editor.apply();
        });

        binding.obligatoirevegetarien.setOnClickListener(v -> {
            vegetarien = 2;

            binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("vegetarien", vegetarien);
            editor.apply();
        });

        binding.pasimportantgluten.setOnClickListener(v -> {
            gluten = 0;

            binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("gluten", gluten);
            editor.apply();
        });

        binding.importantgluten.setOnClickListener(v -> {
            gluten = 1;

            binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("gluten", gluten);
            editor.apply();
        });

        binding.obligatoiregluten.setOnClickListener(v -> {
            gluten = 2;

            binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("gluten", gluten);
            editor.apply();
        });

        switch (preferences.getInt("vegan", -1)) {
            case 0 :
                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance);
                break;
        }

        switch (preferences.getInt("vegetarien", -1)) {
            case 0 :
                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance);
                break;
        }

        switch (preferences.getInt("gluten", -1)){
            case 0 :
                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance);
        }
    }

    public int getVegan() {return vegan;}
    public int getVegetarien() {return vegetarien;}
    public int getGluten() {return gluten;}
}