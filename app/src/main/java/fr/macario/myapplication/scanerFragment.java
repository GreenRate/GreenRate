package fr.macario.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import fr.macario.myapplication.databinding.FragmentScanerBinding;

public class scanerFragment extends Fragment {

    private FragmentScanerBinding binding;
    public scanerFragment() {}

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
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HistoriqueFragment historiqueFragment = new HistoriqueFragment();
            fragmentTransaction.add(R.id.fragment_container_view, historiqueFragment);
            fragmentTransaction.commit();
        });

        binding.buttonClassement.setOnClickListener(v -> {
        });

        binding.buttonScann.setOnClickListener(v -> scanCode());
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() !=null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("Ok", (dialogInteface, which) -> dialogInteface.dismiss()).show();
        }
    });
}