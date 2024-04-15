package fr.macario.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;
import org.json.JSONException;

import fr.macario.myapplication.databinding.FragmentProductBinding;
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
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

import fr.macario.myapplication.databinding.FragmentScanerBinding;

import java.io.IOException;

public class scanerFragment extends Fragment {

    private TextView nompruduit;
    public String barcodeValue;
    public String productName;
    private String productImage;
    public String url;

    public String getProductName() {
        return productName;
    }

    OkHttpClient client = new OkHttpClient();



    private FragmentScanerBinding binding;
    public FragmentProductBinding binding_special;
    public scanerFragment() {}

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), this::onActivityResult);

    public void onActivityResult(ScanIntentResult result) {
        if (result.getContents() != null) {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            barcodeValue = result.getContents();
            url = "https://world.openfoodfacts.net/api/v2/product/" + barcodeValue;
            Request request = new Request.Builder().url(url).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String responseData = response.body().string();
                        try {
                            JSONObject jsonResponse = new JSONObject(responseData);
                            JSONObject productObject = jsonResponse.getJSONObject("product");
                            System.out.println(productObject);
                            System.out.println("productObject");
                            productName = productObject.getString("product_name");
                            productImage = productObject.getString("image_url");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(productName);


                    binding.buttonScann.setVisibility(View.INVISIBLE);
                    binding.buttonCompare.setVisibility(View.INVISIBLE);
                    binding.buttonList.setVisibility(View.INVISIBLE);
                    binding.buttonClassement.setVisibility(View.INVISIBLE);
                    binding.buttonProfile.setVisibility(View.INVISIBLE);
                    binding.logo.setVisibility(View.INVISIBLE);
                    binding.msgBvn.setVisibility(View.INVISIBLE);

                    binding.nompruduit.setVisibility(View.VISIBLE);
                    binding.backproduct.setVisibility(View.VISIBLE);
                    binding.mail.setVisibility(View.VISIBLE);
                    binding.ecoscored.setVisibility(View.VISIBLE);
                    binding.nutriscored.setVisibility(View.VISIBLE);
                    binding.prx.setVisibility(View.VISIBLE);
                    binding.prxPrd.setVisibility(View.VISIBLE);

                    binding.backproduct.setOnClickListener(v -> {

                        binding.nompruduit.setVisibility(View.INVISIBLE);
                        binding.backproduct.setVisibility(View.INVISIBLE);
                        binding.mail.setVisibility(View.INVISIBLE);
                        binding.ecoscored.setVisibility(View.INVISIBLE);
                        binding.nutriscored.setVisibility(View.INVISIBLE);
                        binding.prx.setVisibility(View.INVISIBLE);
                        binding.prxPrd.setVisibility(View.INVISIBLE);

                        binding.buttonScann.setVisibility(View.VISIBLE);
                        binding.buttonCompare.setVisibility(View.VISIBLE);
                        binding.buttonList.setVisibility(View.VISIBLE);
                        binding.buttonClassement.setVisibility(View.VISIBLE);
                        binding.buttonProfile.setVisibility(View.VISIBLE);
                        binding.logo.setVisibility(View.VISIBLE);
                        binding.msgBvn.setVisibility(View.VISIBLE);

                        binding.buttonScann.setEnabled(true);
                        binding.buttonCompare.setEnabled(true);
                        binding.buttonList.setEnabled(true);
                        binding.buttonClassement.setEnabled(true);
                        binding.buttonProfile.setEnabled(true);
                        binding.logo.setEnabled(true);
                        binding.msgBvn.setEnabled(true);

                        binding.nompruduit.setText(productName);
                    });


                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });











                }

            });




























            /*
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ProductFragment productFragment = new ProductFragment();
            fragmentTransaction.add(R.id.fragment_container_view, productFragment);
            fragmentTransaction.commit();

             */



        }
    }

    public void scanCode() {
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

        binding.nompruduit.setVisibility(View.INVISIBLE);
        binding.backproduct.setVisibility(View.INVISIBLE);
        binding.mail.setVisibility(View.INVISIBLE);
        binding.ecoscored.setVisibility(View.INVISIBLE);
        binding.nutriscored.setVisibility(View.INVISIBLE);
        binding.prx.setVisibility(View.INVISIBLE);
        binding.prxPrd.setVisibility(View.INVISIBLE);




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



}

