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

import fr.macario.myapplication.databinding.FragmentLabelBinding;


public class LabelFragment extends Fragment {

    private FragmentLabelBinding binding;
    public LabelFragment() {}

    public int bio;
    public int commerceEquit;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLabelBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();


        binding.backlabel.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
            fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
            fragmentTransaction.commit();
        });

        binding.pasimportantbio.setOnClickListener(v -> {
            bio = 0;

            binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("bio", bio);
            editor.apply();
        });

        binding.importantbio.setOnClickListener(v -> {
            bio = 1;

            binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("bio", bio);
            editor.apply();
        });

        binding.obligatoirebio.setOnClickListener(v -> {
            bio = 2;

            binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("bio", bio);
            editor.apply();
        });

        binding.pasimportantequitable.setOnClickListener(v -> {
            commerceEquit = 0;

            binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("commerceEquit", commerceEquit);
            editor.apply();
        });

        binding.importantequitable.setOnClickListener(v -> {
            commerceEquit = 1;

            binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            editor.putInt("commerceEquit", commerceEquit);
            editor.apply();
        });

        binding.obligatoireequitable.setOnClickListener(v -> {
            commerceEquit = 2;

            binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            editor.putInt("commerceEquit", commerceEquit);
            editor.apply();
        });

        switch (preferences.getInt("bio", -1)){
            case 0 :
                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance);
                break;
        }

        switch (preferences.getInt("commerceEquit", -1)){
            case 0 :
                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 1 :
                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                break;
            case 2 :
                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                break;
            case -1 :
                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance);
        }
    }


}