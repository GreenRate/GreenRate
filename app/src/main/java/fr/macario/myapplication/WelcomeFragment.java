package fr.macario.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.macario.myapplication.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final String[] userName = new String[1];
        super.onViewCreated(view, savedInstanceState);
        binding.ButtonLogin.setEnabled(false);

        binding.usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {
                userName[0] = s.toString();

                boolean usernameIsEmpty = s.toString().isEmpty();

                if (usernameIsEmpty) {
                    binding.ButtonLogin.setEnabled(!usernameIsEmpty);
                } else {
                    binding.ButtonLogin.setEnabled(usernameIsEmpty);
                }

                binding.ButtonLogin.setEnabled(!usernameIsEmpty);
            }
        });

        binding.ButtonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.d("userName", "l'utilisateur s'appelle " + userName[0]);

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                scanFragment ScanFragment = new scanFragment();
                fragmentTransaction.add(R.id.fragment_container_view, ScanFragment);
                fragmentTransaction.commit();
            }
        });
    }
}