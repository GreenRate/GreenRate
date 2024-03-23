package fr.macario.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentProfilBinding;


public class ProfilFragment extends Fragment {

    private FragmentProfilBinding binding;
    public String userNameInput = new WelcomeFragment().getUserNameInput();

    public ProfilFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfilBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        binding.username.setText(userNameInput);
        binding.buttonSettings.setOnClickListener(v -> {
            binding.backprofil.setEnabled(false);
            binding.buttonSettings.setEnabled(false);
            binding.buttonContact.setEnabled(false);
            binding.buttonPartenaire.setEnabled(false);
            binding.buttonPrefAlim.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SettingFragment settingFragment = new SettingFragment();
            fragmentTransaction.add(R.id.fragment_container_view, settingFragment);
            fragmentTransaction.commit();
        });

        binding.backprofil.setOnClickListener(v -> {
            binding.backprofil.setEnabled(false);
            binding.buttonSettings.setEnabled(false);
            binding.buttonContact.setEnabled(false);
            binding.buttonPartenaire.setEnabled(false);
            binding.buttonPrefAlim.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            scanerFragment scanerFragment = new scanerFragment();
            fragmentTransaction.add(R.id.fragment_container_view, scanerFragment);
            fragmentTransaction.commit();
        });

        binding.buttonPrefAlim.setOnClickListener(v -> {
            binding.backprofil.setEnabled(false);
            binding.buttonSettings.setEnabled(false);
            binding.buttonContact.setEnabled(false);
            binding.buttonPartenaire.setEnabled(false);
            binding.buttonPrefAlim.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
            fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
            fragmentTransaction.commit();
        });

        binding.buttonContribuer.setOnClickListener(v -> {

        });

        binding.buttonContact.setOnClickListener(v -> {

        });

        binding.buttonPartenaire.setOnClickListener(v -> {

        });
    }
}