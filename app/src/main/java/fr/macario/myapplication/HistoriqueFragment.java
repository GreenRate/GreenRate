package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.PublicKey;

import fr.macario.myapplication.databinding.FragmentHistoriqueBinding;
import fr.macario.myapplication.databinding.FragmentScanerBinding;


public class HistoriqueFragment extends Fragment {

    private FragmentHistoriqueBinding binding;
    public HistoriqueFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoriqueBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backhistorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                scanerFragment scanerFragment = new scanerFragment();
                fragmentTransaction.add(R.id.fragment_container_view, scanerFragment);
                fragmentTransaction.commit();
            }
        });

    }
}