package fr.macario.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import fr.macario.myapplication.databinding.FragmentHistoriqueBinding;


public class HistoriqueFragment extends Fragment {

    private FragmentHistoriqueBinding binding;
    public HistoriqueFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoriqueBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backhistorique.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            scanerFragment scanerFragment = new scanerFragment();
            fragmentTransaction.add(R.id.fragment_container_view, scanerFragment);
            fragmentTransaction.commit();
        });

    }
}