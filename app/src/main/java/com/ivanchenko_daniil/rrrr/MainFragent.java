package com.ivanchenko_daniil.rrrr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragent extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;

    public MainFragent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        Button showPhotosButton = view.findViewById(R.id.showPhotosButton);
        showPhotosButton.setBackgroundTintList(getResources().getColorStateList(R.color.yellow));
        showPhotosButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showPhotosButton:
                showPhotos();
                break;
        }
    }

    private void showPhotos() {
        recyclerView.setVisibility(View.VISIBLE);

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://sich.zp.ua/wp-content/uploads/2021/02/Park_Voznesenivs_kyj-1024x583.jpg");
        photoUrls.add("https://sich.zp.ua/wp-content/uploads/2021/02/Ploshcha_Maiakovs_koho-1024x668.jpg");
        photoUrls.add("https://sich.zp.ua/wp-content/uploads/2021/02/Mural_na_fasadi_shkoly_mystetstv_-3-1024x682.jpg");
        photoUrls.add("https://sich.zp.ua/wp-content/uploads/2021/02/Natsional_nyj_zapovidnyk_-Khortytsia--1024x683.jpg");
        photoUrls.add("https://zp.gov.ua/upload/editor/prospekt-sobornyj.jpg");
        photoUrls.add("https://i.pinimg.com/originals/7a/23/23/7a2323ca6cfa9fbd6425e59a329d37d3.jpg");
        photoUrls.add("https://ki.ill.in.ua/a/675x0/24113486.jpg");

        photoAdapter = new PhotoAdapter(photoUrls, requireContext());
        recyclerView.setAdapter(photoAdapter);
    }
}


