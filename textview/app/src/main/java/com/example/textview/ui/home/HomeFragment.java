package com.example.textview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.textview.databinding.FragmentHomeBinding;
import com.example.textview.ui.Shareviewmodel;

public class HomeFragment extends Fragment {
    Shareviewmodel shareviewmodel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Shareviewmodel shareviewmodel = new ViewModelProvider(requireActivity()).get(Shareviewmodel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        shareviewmodel.getListdata().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        binding.textHome.setText(shareviewmodel.getListdata().getValue().toString());
//    }
}