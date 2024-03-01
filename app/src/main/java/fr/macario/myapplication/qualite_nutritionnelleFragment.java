package fr.macario.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import fr.macario.myapplication.databinding.FragmentQualiteNutritionnelleBinding;


public class qualite_nutritionnelleFragment extends Fragment {


    private FragmentQualiteNutritionnelleBinding binding;
    public qualite_nutritionnelleFragment() {}

    public int Bonnequal;
    public int faibleQuantMatiereGrasse;
    public int quantSel;
    public int quantSucre;
    public int quantAcide;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQualiteNutritionnelleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backprefalimantaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PrefAlimentairesFragment prefAlimentairesFragment = new PrefAlimentairesFragment();
                fragmentTransaction.add(R.id.fragment_container_view, prefAlimentairesFragment);
                fragmentTransaction.commit();
            }
        });

        binding.pasimportantqualiteenutritionnelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bonnequal = 0;

                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantqualiteenutritionnelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bonnequal = 1;

                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoirequaliteenutritionnelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bonnequal = 2;

                binding.pasimportantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantqualiteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirequaliteenutritionnelle.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantmatiereqrasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faibleQuantMatiereGrasse = 0;

                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantmatiereqrasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faibleQuantMatiereGrasse = 1;

                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoirematiereqrasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faibleQuantMatiereGrasse = 2;

                binding.pasimportantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantmatiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoirematiereqrasse.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSel = 0;

                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSel = 1;

                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoiresel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSel = 2;

                binding.pasimportantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsel.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresel.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantsucre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSucre = 0;

                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantsucre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSucre = 1;

                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoiresucre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantSucre = 2;

                binding.pasimportantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantsucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiresucre.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });

        binding.pasimportantgras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantAcide = 0;

                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.importantgras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantAcide = 1;

                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
            }
        });

        binding.obligatoiregras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantAcide = 2;

                binding.pasimportantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.importantgras.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
                binding.obligatoiregras.setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
            }
        });
    }

    public int getBonnequal() {return Bonnequal;}
    public int getFaibleQuantMatiereGrasse() {return faibleQuantMatiereGrasse;}
    public int getQuantAcide() {return quantAcide;}
    public int getQuantSel() {return quantSel;}
    public int getQuantSucre() {return quantSucre;}
}