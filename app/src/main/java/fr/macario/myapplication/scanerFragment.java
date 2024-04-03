package fr.macario.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;
import org.json.JSONException;

import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.net.*;
import java.io.*;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import fr.macario.myapplication.databinding.FragmentScanerBinding;

import java.io.IOException;

public class scanerFragment extends Fragment {

    private String barcodeValue;
    private String productName;


    private FragmentScanerBinding binding;
    public scanerFragment() {}

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() !=null) {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            barcodeValue = result.getContents();
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ProductFragment productFragment = new ProductFragment();
            fragmentTransaction.add(R.id.fragment_container_view, productFragment);
            fragmentTransaction.commit();
            barcodeValue = result.getContents();
        }
    });

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScanerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonProfile.setOnClickListener(v -> {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ProfilFragment profileFragment = new ProfilFragment();
            fragmentTransaction.add(R.id.fragment_container_view, profileFragment);
            fragmentTransaction.commit();
        });

        binding.buttonCompare.setOnClickListener(v -> {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            compare_fragment compareFragment = new compare_fragment();
            fragmentTransaction.add(R.id.fragment_container_view, compareFragment);
            fragmentTransaction.commit();
        });

        binding.buttonList.setOnClickListener(v -> {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HistoriqueFragment historiqueFragment = new HistoriqueFragment();
            fragmentTransaction.add(R.id.fragment_container_view, historiqueFragment);
            fragmentTransaction.commit();
        });

        binding.buttonClassement.setOnClickListener(v -> {});
        binding.buttonScann.setOnClickListener(v -> scanCode());
    }



    public String getBarcodeValue() {
        return barcodeValue;
    }
}

