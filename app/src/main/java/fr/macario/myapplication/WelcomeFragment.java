package fr.macario.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import fr.macario.myapplication.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {


    private FragmentWelcomeBinding binding;
    public static String userNameInput = "user";
    public static String mypreference = "mypref";


    public String getUserNameInput (){
        return userNameInput;
    }


    public WelcomeFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences.edit();

        binding.ButtonLogin.setEnabled(false);
        binding.lastName.setText(preferences.getString("userName", "user"));



        binding.usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {

                userNameInput = s.toString();

                boolean usernameIsEmpty = s.toString().isEmpty();

                if (usernameIsEmpty) {
                    binding.ButtonLogin.setEnabled(false);
                } else {
                    binding.ButtonLogin.setEnabled(usernameIsEmpty);
                }

                binding.ButtonLogin.setEnabled(!usernameIsEmpty);
            }
        });

        binding.ButtonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("userName", userNameInput);
                editor.apply();

                Log.d("userName", "l'utilisateur s'appelle " + preferences.getString("userName", "user"));
                userNameInput = preferences.getString("userName", "user");
                binding.lastName.setText(preferences.getString("userName", "user"));

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                scanFragment ScanFragment = new scanFragment();
                fragmentTransaction.add(R.id.fragment_container_view, ScanFragment);
                fragmentTransaction.commit();

            }
        });
    }



}