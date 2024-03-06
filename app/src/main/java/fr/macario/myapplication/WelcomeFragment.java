package fr.macario.myapplication;

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

import fr.macario.myapplication.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    public static String userName;
    public String getUserNameInput (){return userName;}
    public WelcomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        userName = preferences.getString("userName", "user");

        int gluten = new ingredientFragment().getGluten();
        System.out.println(gluten);

        if (userName.equals("user")){
            binding.ButtonLogin.setEnabled(false);
            binding.usernameInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {

                    userName = s.toString();
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
                    editor.putString("userName", userName);
                    editor.apply();
                    userName = preferences.getString("userName", "user");
                    Log.d("userName", "l'utilisateur s'appelle " + preferences.getString("userName", "user"));
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    scanerFragment ScanFragment = new scanerFragment();
                    fragmentTransaction.add(R.id.fragment_container_view, ScanFragment);
                    fragmentTransaction.commit();
                }
            });
        } else {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            scanerFragment ScanerFragment = new scanerFragment();
            fragmentTransaction.add(R.id.fragment_container_view, ScanerFragment);
            fragmentTransaction.commit();
        }
    }
}