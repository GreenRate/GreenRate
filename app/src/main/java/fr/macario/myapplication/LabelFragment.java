package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentLabelBinding;
import fr.macario.myapplication.databinding.FragmentProfilBinding;


public class LabelFragment extends Fragment {

    private FragmentLabelBinding binding;
    public LabelFragment() {}

    public int bio;
    public int commerceEquit;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLabelBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
                fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
                fragmentTransaction.commit();
            }
        });

        binding.pasimportantbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bio = 0;

                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bio = 1;

                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoirebio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bio = 2;

                binding.pasimportantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantbio.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirebio.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantequitable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commerceEquit = 0;

                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantequitable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commerceEquit = 1;

                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoireequitable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commerceEquit = 2;

                binding.pasimportantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoireequitable.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });
    }
}