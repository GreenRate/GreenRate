package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentIngredientBinding;
import fr.macario.myapplication.databinding.FragmentProfilBinding;

public class ingredientFragment extends Fragment {

    private FragmentIngredientBinding binding;
    public ingredientFragment() {}

    public int vegan;
    public int vegetarien;
    public int gluten;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIngredientBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
                fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
                fragmentTransaction.commit();
            }
        });

        binding.pasimportantvegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegan = 0;

                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantvegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegan = 1;

                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoirevegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegan = 2;

                binding.pasimportantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegan.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantvegetarien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegetarien = 0;

                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantvegetarien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegetarien = 1;

                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoirevegetarien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegetarien = 2;

                binding.pasimportantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantvegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirevegetarien.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantgluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gluten = 0;

                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantgluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gluten = 1;

                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoiregluten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gluten = 2;

                binding.pasimportantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregluten.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });
    }
}