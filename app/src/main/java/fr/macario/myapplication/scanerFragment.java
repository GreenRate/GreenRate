package fr.macario.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

import com.bumptech.glide.Glide;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

import fr.macario.myapplication.databinding.FragmentScanerBinding;

import java.io.IOException;
import java.util.Objects;

public class scanerFragment extends Fragment {


    public ImageView imgProduit;
    public ImageView nutriScore;
    private TextView nompruduit;
    public String barcodeValue;
    public String productName;
    private String productImage;
    private String productNutriScore;
    private String productEcoScore;
    public String url;
    public URL urlImage = null;

    public String getProductName() {
        return productName;
    }

    OkHttpClient client = new OkHttpClient();



    private FragmentScanerBinding binding;
    public scanerFragment() {}

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), this::onActivityResult);

    public void onActivityResult(ScanIntentResult result) {
        if (result.getContents() != null) {
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
                            productNutriScore = productObject.getString("nutriscore_grade");
                            productEcoScore = productObject.getString("ecoscore_grade");
                            urlImage = new URL(productImage);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }





                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle(productName);
                            builder.setMessage(result.getContents());


                            builder.setMessage("Nutriscore : " + productNutriScore.toUpperCase() + "\nEcoscore : " + productEcoScore.toUpperCase());
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                        }
                    });
                }
            });
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

        binding.buttonClassement.setOnClickListener(v -> {
            binding.buttonProfile.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonList.setEnabled(false);
            binding.buttonCompare.setEnabled(false);
            binding.buttonScann.setEnabled(false);
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            fragmentTransaction.add(R.id.fragment_container_view, searchFragment);
            fragmentTransaction.commit();
        });
        binding.buttonScann.setOnClickListener(v -> scanCode());
    }



}