package fr.macario.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentScanBinding;


public class scanFragment extends Fragment {

    private FragmentScanBinding binding;

    public scanFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentScanBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.d("userName", "l'utilisateur va vers le profile");

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ProfilFragment profileFragment = new ProfilFragment();
                fragmentTransaction.add(R.id.fragment_container_view, profileFragment);
                fragmentTransaction.commit();
            }
        });

        binding.buttonComparaison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("comparaison_go", "l'utilisateur va vers les comparaison");

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                compare_fragment compareFragment = new compare_fragment();
                fragmentTransaction.add(R.id.fragment_container_view, compareFragment);
                fragmentTransaction.commit();
            }
        });

        binding.answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "message de test");
            }
        });

    }
}